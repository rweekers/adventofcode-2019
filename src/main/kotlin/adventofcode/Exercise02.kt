package adventofcode

class Exercise02(input: String) {

    private val initialList = lineAsListOfInts(input)
    private var inputList = initialList.toMutableList()

    fun silverExercise(noun: Int? = null, verb: Int? = null): Int {
        runProgram(noun, verb)
        return inputList[0]
    }

    private fun runProgram(noun: Int? = null, verb: Int? = null) {
        inputList = initialList.toMutableList()
        prepareList(noun, verb)
        var currentIndex = 0
        do {
            val chunk = extractChunk(currentIndex)
            processChunk(chunk)
            currentIndex += 4

        } while (inputList[currentIndex] != 99)
    }

    private fun extractChunk(currentIndex: Int): Chunk {
        return Chunk(Opcode.getByCode(inputList[currentIndex]), inputList[currentIndex + 1], inputList[currentIndex + 2], inputList[currentIndex + 3])
    }

    private fun processChunk(chunk: Chunk) {
        when (chunk.opcode) {
            Opcode.ADD -> inputList[chunk.targetIndex] = inputList[chunk.indexOperandOne].plus(inputList[chunk.indexOperandTwo])
            Opcode.MULTIPLY -> inputList[chunk.targetIndex] = inputList[chunk.indexOperandOne].times(inputList[chunk.indexOperandTwo])
        }
    }

    private fun prepareList(noun: Int?, verb: Int?) {
        inputList[1] = noun ?: inputList[1]
        inputList[2] = verb ?: initialList[2]
    }

    private enum class Opcode(val code: Int) {
        ADD(1),
        MULTIPLY(2);

        companion object {
            fun getByCode(code: Int): Opcode {
                for (operator in values()) {
                    if (operator.code == code) {
                        return operator
                    }
                }
                throw RuntimeException("Operator with code $code not found.")
            }
        }
    }

    private class Chunk(val opcode: Opcode, val indexOperandOne: Int, val indexOperandTwo: Int, val targetIndex: Int)

    fun goldExercise(): Int {
        (0..99).forEach {noun ->
            (0..99).forEach { verb ->
                runProgram(noun, verb)
                if (inputList[0] == 19690720) {
                    return 100.times(noun).plus(verb)
                }
            }
        }
        // Apparently we didn't find anything
        return -1
    }
}

fun main() {
    val exc2 = Exercise02("/input02.txt")
    println("The answer to the silver exercise is ${exc2.silverExercise(12, 2)}")
    println("The answer to the gold exercise is ${exc2.goldExercise()}")
}
