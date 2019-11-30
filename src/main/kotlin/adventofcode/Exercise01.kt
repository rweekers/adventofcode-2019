package adventofcode

class Exercise01(input: String) {

    private val inputList: List<String> = resourceAsListOfString(input)

    fun silverExercise(): Int {
        inputList.forEach { println(it) }
        return 0
    }

    fun goldExercise(): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    val exc1 = Exercise01("/input01.txt")
    println("The answer to the silver exercise is ${exc1.silverExercise()}")
    println("The answer to the gold exercise is ${exc1.goldExercise()}")
}
