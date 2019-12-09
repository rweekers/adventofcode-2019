package adventofcode

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


    fun goldExercise(): Int {
        return 0
    }
}

fun main() {
    val exc7 = Exercise07("/input07.txt")
    println("The answer to the silver exercise is ${exc7.silverExercise()}")
    println("The answer to the gold exercise is ${exc7.goldExercise()}")
}
