package adventofcode

class Exercise03(input: String) {

    private val inputList1: List<Movement> = lineAsListOfStrings(input, 0).map { transformToMovement(it) }
    private val inputList2: List<Movement> = lineAsListOfStrings(input, 1).map { transformToMovement(it) }
    private val path1 = inputList1.fold(listOf(Point(0, 0))) { acc, curr -> executeMovement(curr, acc) }
    private val path2 = inputList2.fold(listOf(Point(0, 0))) { acc, curr -> executeMovement(curr, acc) }
    private val intersections = path1.innerJoin(path2).filter { it.x != 0 && it.y != 0 }

    fun silverExercise(): Int =
            intersections.map { it.manhattanDistanceToOrigin() }.min()
                    ?: throw RuntimeException("Did not find an intersection")

    private fun executeMovement(movement: Movement, path: List<Point>): List<Point> =
            (0 until movement.steps).fold(path) { acc, _ ->
                val newPath = acc.toMutableList()
                val lastPoint = acc.last()
                when (movement.direction) {
                    Direction.UP -> newPath.add(Point(lastPoint.x, lastPoint.y + 1))
                    Direction.DOWN -> newPath.add(Point(lastPoint.x, lastPoint.y - 1))
                    Direction.LEFT -> newPath.add(Point(lastPoint.x - 1, lastPoint.y))
                    Direction.RIGHT -> newPath.add(Point(lastPoint.x + 1, lastPoint.y))
                }
                newPath.toList()
            }

    fun goldExercise(): Int =
            intersections.map { Pair(path1.indexOf(it), path2.indexOf(it)) }.map { it.first + it.second }.min()
                    ?: throw RuntimeException("Did not find an intersection")

    private fun transformToMovement(it: String): Movement =
            Movement(it.substring(1).toInt(), Direction.getByCode(it[0].toString()))

    private data class Movement(val steps: Int, val direction: Direction) {
        override fun toString(): String {
            return "Going $direction for $steps steps"
        }
    }

    private enum class Direction(val code: String) {
        RIGHT("R"),
        LEFT("L"),
        UP("U"),
        DOWN("D");

        companion object {
            fun getByCode(code: String): Direction {
                for (direction in values()) {
                    if (direction.code == code) {
                        return direction
                    }
                }
                throw RuntimeException("Operator with code $code not found.")
            }
        }
    }
}

fun main() {
    val exc3 = Exercise03("/input03.txt")
    println("The answer to the silver exercise is ${exc3.silverExercise()}")
    println("The answer to the gold exercise is ${exc3.goldExercise()}")
}
