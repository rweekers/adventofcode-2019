package adventofcode

import kotlin.math.absoluteValue

data class Point(val x: Int, val y: Int) {

    fun manhattanDistanceToOrigin(): Int {
        return x.absoluteValue + y.absoluteValue
    }
}