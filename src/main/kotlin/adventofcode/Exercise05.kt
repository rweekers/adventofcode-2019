package adventofcode

class Exercise05(input: String) {

    private val initialList = lineAsListOfInts(input)
    private var inputList: MutableList<Int> = mutableListOf()
    private var parameter = 1

    fun silverExercise(): Int {
        inputList.forEach { println(it) }
        runProgram()
        return 0
    }

    private fun runProgram() {
        inputList = initialList.toMutableList()
        var currentIndex = 0
        do {
            currentIndex += processChunk(currentIndex)
        } while (inputList[currentIndex] != 99)
    }

    private fun processChunk(currentIndex: Int): Int {
        val code = MemCodeInstruction.getByCode(inputList[currentIndex].toString().takeLast(2).toInt())

        when (code) {
            MemCodeInstruction.INPUT -> println("TODO")
            MemCodeInstruction.OUTPUT -> println("TOOD")
            MemCodeInstruction.ADD -> println("TODO")
            MemCodeInstruction.MULTIPLY -> println("TODO")
            MemCodeInstruction.END -> println("TODO")
        }

        return currentIndex + code.length
    }

    private class Chunk(val memCodeInstruction: MemCodeInstruction, val indexOperandOne: Int, val indexOperandTwo: Int, val targetIndex: Int)

    private enum class MemCodeInstruction(val code: Int, val length: Int) {
        INPUT(3, 1),
        OUTPUT(4, 1),
        ADD(1, 4),
        MULTIPLY(2, 4),
        END(99, 1);

        companion object {
            fun getByCode(code: Int): MemCodeInstruction {
                for (memCodeInstruction in MemCodeInstruction.values()) {
                    if (memCodeInstruction.code == code) {
                        return memCodeInstruction
                    }
                }
                throw RuntimeException("MemCodeInstruction with code $code not found.")
            }
        }
    }

    fun goldExercise(): Int {
        return 0
    }
}

fun main() {
    val exc5 = Exercise05("/input05.txt")
    println("The answer to the silver exercise is ${exc5.silverExercise()}")
    println("The answer to the gold exercise is ${exc5.goldExercise()}")
}
