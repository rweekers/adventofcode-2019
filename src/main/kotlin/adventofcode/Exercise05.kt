package adventofcode

class Exercise05(input: String) {

    private val initialList = commaSeparatedLineAsListOfInts(input)
    private val intCode = IntCode(initialList)

    fun silverExercise(): Int {
        return intCode.runProgram()
    }

    fun goldExercise(): Int {
        return intCode.runProgram(5)
    }
}

fun main() {
    val exc5 = Exercise05("/input05.txt")
    println("The answer to the silver exercise is ${exc5.silverExercise()}")
    println("The answer to the gold exercise is ${exc5.goldExercise()}")
}
