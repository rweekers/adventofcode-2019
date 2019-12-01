package adventofcode

class Exercise01(input: String) {

    private val inputList: List<String> = resourceAsListOfString(input)

    fun silverExercise(): Long {
        return inputList.map { calculateFuelForMass(it.toLong()) }.reduce { acc, curr -> acc + curr }
    }

    private fun calculateFuelForMass(mass: Long) =
            mass.div(3L) - 2

    private fun calculateFuel(fuel: Long, totalFuel: Long): Long {
        val extraFuelNeeded = fuel.div(3L) - 2
        return if (extraFuelNeeded <= 0) {
            return totalFuel
        } else {
            calculateFuel(extraFuelNeeded, totalFuel.plus(extraFuelNeeded))
        }
    }

    fun goldExercise(): Long {
        return inputList.map { calculateFuelForMass(it.toLong()) }.map { calculateFuel(it, it) }
                .reduce { acc, curr -> acc + curr }
    }
}

fun main(args: Array<String>) {
    val exc1 = Exercise01("/input01.txt")
    println("The answer to the silver exercise is ${exc1.silverExercise()}")
    println("The answer to the gold exercise is ${exc1.goldExercise()}")
}
