package adventofcode

class Exercise04 {

    private val start = 171309
    private val end = 643603

    private val input = (start..end)
            .map { it.toListOfInt() }

    fun silverExercise(): Int {
        return input
                .filter { allDigitsIncreasingOrEqual(it) && hasAtLeastTwoSubsequentEqualDigits(it) }.count()
    }

    fun hasAtLeastTwoSubsequentEqualDigits(input: List<Int>): Boolean =
            input
                    .zipWithNext { a, b -> a == b }
                    .any { it }

    fun hasExactlyTwoSubsequentEqualDigits(input: List<Int>): Boolean =
            (0..9)
                    .any { input.indexOf(it) == input.lastIndexOf(it) - 1 }

    fun allDigitsIncreasingOrEqual(input: List<Int>): Boolean =
            (0..4).all { input[it] <= input[it + 1] }

    fun goldExercise(): Int {
        return input.filter { allDigitsIncreasingOrEqual(it) && hasExactlyTwoSubsequentEqualDigits(it) }.count()
    }
}

fun main() {
    val exc4 = Exercise04()
    println("The answer to the silver exercise is ${exc4.silverExercise()}")
    println("The answer to the gold exercise is ${exc4.goldExercise()}")
}
