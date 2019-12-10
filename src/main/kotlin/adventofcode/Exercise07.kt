package adventofcode

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class Exercise07(input: String) {

    private val initialList = commaSeparatedLineAsListOfInts(input)

    fun silverExercise(): Int {
        return listOf(0, 1, 2, 3, 4).permutations().map { runPhase(it) }.max()
                ?: throw RuntimeException("No max value, something is wrong")
    }

    private fun runPhase(settings: List<Int>): Int =
            (0..4).fold(0) { past, id ->
                IntCode(initialList.toMutableList(), mutableListOf(settings[id], past)).runProgram()
            }

    private suspend fun runAmplified(settings: List<Int>): Int = coroutineScope {

        val a = IntCode(initialList.toMutableList(), listOf(settings[0], 0).toChannel())
        val b = IntCode(initialList.toMutableList(), a.output.andSend(settings[1]))
        val c = IntCode(initialList.toMutableList(), b.output.andSend(settings[2]))
        val d = IntCode(initialList.toMutableList(), c.output.andSend(settings[3]))
        val e = IntCode(initialList.toMutableList(), d.output.andSend(settings[4]))
        val channelSpy = ChannelSpy(e.output, a.parameter)

        coroutineScope {
            launch { channelSpy.listen() }
            launch { a.runSuspending() }
            launch { b.runSuspending() }
            launch { c.runSuspending() }
            launch { d.runSuspending() }
            launch { e.runSuspending() }
        }
        channelSpy.spy.receive()
    }

    private suspend fun <T> Channel<T>.andSend(msg: T): Channel<T> =
            this.also { send(msg) }

    fun goldExercise(): Int {
        return 0
    }
}

class ChannelSpy<T>(
        private val input: Channel<T>,
        private val output: Channel<T>,
        val spy: Channel<T> = Channel(Channel.CONFLATED)) {

    suspend fun listen() = coroutineScope {
        for (received in input) {
            spy.send(received)
            output.send(received)
        }
    }
}

fun main() {
    val exc7 = Exercise07("/input07.txt")
    println("The answer to the silver exercise is ${exc7.silverExercise()}")
    println("The answer to the gold exercise is ${exc7.goldExercise()}")
}
