package adventofcode

import kotlin.math.absoluteValue
import kotlin.math.atan2
import kotlin.math.pow
import kotlin.math.sqrt

class Exercise10(input: String) {

    private val lines = resourceAsListOfString(input)
    private val points = mutableListOf<Point>()
    private val mapOfPoints = mutableMapOf<Point, Boolean>()

    init {
        lines.forEachIndexed { indexY, row ->
            row.toListOfSingleStrings().forEachIndexed { indexX, element ->
                val point = Point(indexX, indexY)
                points.add(point)
                mapOfPoints[point] = element == "#"
            }
        }
    }

    fun silverExercise(): Int {
        return findBestLocationAndScore().second
    }

    private fun findBestLocationAndScore(): Pair<Point, Int> =
            mapOfPoints.entries.filter { it.value }.map {
                val originalPoint = it.key

                val otherAsteroids = mapOfPoints.entries.filter { coordinate -> coordinate.value && coordinate.key != originalPoint }.map { otherPoint -> otherPoint.key }
                originalPoint to otherAsteroids.map { asteroid -> toTan(asteroid, originalPoint) }.distinct().count()
            }.maxBy { it.second } ?: throw RuntimeException("No valid points found")

    private fun toTan(asteroid: Point, centerPoint: Point): Double {
        return atan2(asteroid.y.toDouble() - centerPoint.y.toDouble(), asteroid.x.toDouble() - centerPoint.x.toDouble())
    }

    fun goldExercise(): Int {
        val originalAsteroid = findBestLocationAndScore().first
        val otherAsteroids = mapOfPoints.entries.filter { coordinate -> coordinate.value && coordinate.key != originalAsteroid }.map { otherPoint -> otherPoint.key }
        val groupedAsteroids = otherAsteroids
                .groupBy { normalizedAngleFrom(it, originalAsteroid) }
                .entries.sortedBy { it.key }
                .map {
                    it.key to it.value.sortedBy { asteroid -> distanceFrom(asteroid, originalAsteroid) }.toMutableList()
                }

        var count = 0
        while (true) {
            groupedAsteroids.forEach { (_, asteroids) ->
                if (asteroids.isNotEmpty()) {
                    count++
                    val nextAsteroid = asteroids.removeAt(0)
                    if (count == 200) {
                        return nextAsteroid.x * 100 + nextAsteroid.y
                    }
                }
            }
        }
    }

    private fun distanceFrom(point: Point, originalPoint: Point): Double =
            sqrt((point.x.toDouble() - originalPoint.x.toDouble()).absoluteValue.pow(2) + (point.y.toDouble() - originalPoint.y.toDouble()).absoluteValue.pow(2))


    private fun normalizedAngleFrom(point: Point, originalPoint: Point): Double =
            atan2(point.y.toDouble() - originalPoint.y.toDouble(), point.x.toDouble() - originalPoint.x.toDouble())
                    .let { if (it < -Math.PI / 2) it + 2 * Math.PI else it }

}

fun main() {
    val exc10 = Exercise10("/input10.txt")
    println("The answer to the silver exercise is ${exc10.silverExercise()}")
    println("The answer to the silver exercise is ${exc10.goldExercise()}")
}
