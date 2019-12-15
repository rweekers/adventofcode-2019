package adventofcode

class Exercise12(input: String) {

    private val lines = resourceAsListOfString(input)
    private val startingMoons = lines.map { line ->
        val regExp = """[-]?\d+""".toRegex()
        val positionParts = regExp.findAll(line).toList().map { it.value.toInt() }
        Moon(Position(positionParts[0], positionParts[1], positionParts[2]), Velocity())
    }

    fun silverExercise(steps: Int): Int {
        val lastPositions = (0 until steps).fold(startingMoons) { acc, _ ->
            acc.map { moon ->
                val otherMoons = acc.filter { it != moon }
                moon.processStep(otherMoons)
            }
        }
        return lastPositions.map { it.kineticEnergy }.sum()
    }

    fun goldExercise(): Long {
        var moons = startingMoons.toList()

        val startingX: List<Pair<Int, Int>> = moons.map { it.position.x to it.velocity.x }
        val startingY: List<Pair<Int, Int>> = moons.map { it.position.y to it.velocity.y }
        val startingZ: List<Pair<Int, Int>> = moons.map { it.position.z to it.velocity.z }
        var xFound: Long? = null
        var yFound: Long? = null
        var zFound: Long? = null
        var steps = 0L
        do {
            steps += 1
            moons = step(moons)
            xFound = if (xFound == null && startingX == moons.map { it.position.x to it.velocity.x }) steps else xFound
            yFound = if (yFound == null && startingY == moons.map { it.position.y to it.velocity.y }) steps else yFound
            zFound = if (zFound == null && startingZ == moons.map { it.position.z to it.velocity.z }) steps else zFound

        } while (xFound == null || yFound == null || zFound == null)

        return lcm(xFound, lcm(yFound, zFound))
    }

    private fun step(moons: List<Moon>) =
            moons.map { moon ->
                val otherMoons = moons.filter { it != moon }
                moon.processStep(otherMoons)
            }
}

fun main() {
    val exc12 = Exercise12("/input12.txt")
    println("The answer to the silver exercise is ${exc12.silverExercise(1000)}")
    println("The answer to the silver exercise is ${exc12.goldExercise()}")
}
