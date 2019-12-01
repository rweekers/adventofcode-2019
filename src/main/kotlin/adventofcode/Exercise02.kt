package adventofcode

class Exercise02(input: String) {

    private val inputList: List<String> = resourceAsListOfString(input)

    fun silverExercise(): Long {
        inputList.forEach { println(it) }
        return 0
    }

    fun goldExercise(): Long {
        return 0
    }
}

fun main() {
    val exc2 = Exercise02("/input02.txt")
    println("The answer to the silver exercise is ${exc2.silverExercise()}")
    println("The answer to the gold exercise is ${exc2.goldExercise()}")
}
