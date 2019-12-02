package adventofcode

class Exercise03(input: String) {

    private val inputList: List<Long> = resourceAsListOfLong(input)

    fun silverExercise(): Long {
        inputList.forEach { println(it) }
        return 0
    }

    fun goldExercise(): Long {
        inputList.forEach { println(it) }
        return 0
    }
}

fun main() {
    val exc3 = Exercise03("/input03.txt")
    println("The answer to the silver exercise is ${exc3.silverExercise()}")
    println("The answer to the gold exercise is ${exc3.goldExercise()}")
}
