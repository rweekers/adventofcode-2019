package adventofcode

class Exercise04(input: String) {

    private val inputList = resourceAsListOfString(input)

    fun silverExercise(): Int {
        inputList.forEach { println(it) }
        return 0
    }

    fun goldExercise(): Int {
        inputList.forEach { println(it) }
        return 0
    }
}

fun main() {
    val exc4 = Exercise04("/input04.txt")
    println("The answer to the silver exercise is ${exc4.silverExercise()}")
    println("The answer to the gold exercise is ${exc4.goldExercise()}")
}
