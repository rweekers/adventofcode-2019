package adventofcode

class Exercise08(input: String, private val width: Int, private val height: Int, private val lineLength: Int = width * height) {

    private val initialList = lineAsListOfInts(input)
    private val layersWithLines: List<List<List<Int>>> = initialList.windowed(width, width).windowed(height, height)
    private val layers = layersWithLines.map { it.flatten() }
    private val chosenLayer = layers.minBy { line -> line.count { it == 0 } }
            ?: throw RuntimeException("No layer found")

    fun silverExercise(): Int {
        return chosenLayer.count { it == 1 }.times(chosenLayer.count { it == 2 })
    }

    fun goldExercise() {
        val layers = layers.map { it.joinToString(separator = "") }

        (0 until lineLength)
                .map { layers.pixelAt(it) }
                .chunked(width)
                .forEach {
                    println(it.joinToString(separator = ""))
                }
    }

    private fun List<String>.pixelAt(at: Int): Char =
            if (map { it[at] }.firstOrNull { it != '2' } == '1') '#' else ' '
}

fun main() {
    val exc8 = Exercise08("/input08.txt", 25, 6)
    println("The answer to the silver exercise is ${exc8.silverExercise()}")
    println("Printing answer to gold exercise...")
    exc8.goldExercise()
}
