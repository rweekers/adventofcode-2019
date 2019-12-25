package adventofcode

class Exercise14(input: String) {

    private val lines = resourceAsListOfString(input)
    private val recipes = mutableListOf<Recipe>()

    fun silverExercise(): Int {
        lines.forEach { line ->
            val parts = line.split(" => ")
            val target = parts.last().split(" ")
            val targetIngredient = Ingredient(target[0].toLong(), target[1])
            val ingredients = parts.first().split(", ").map {
                val tmp = it.split(" ")
                Ingredient(tmp[0].toLong(), tmp[1])
            }
            val recipe = Recipe(targetIngredient, ingredients)
            recipes.add(recipe)
            println(line)
        }
        return 0
    }

    private fun calculateOreNeeded(targetMaterial: String = "FUEL"): Int {


        return 0
    }

    private fun calculateCost(ingredient: Ingredient = Ingredient(1, "FUEL"),
                              inventory: MutableMap<String, Long> = mutableMapOf()): Long {
        val material = ingredient.material
        val amount = ingredient.amount
        return if (material == "ORE") amount
        else {
            val inventoryQuantity = inventory.getOrDefault(material, 0L)
            val needQuantity = if (inventoryQuantity > 0) {
                // We have some in inventory, check it out of inventory and reduce our need.
                inventory[material] = (inventoryQuantity - amount).coerceAtLeast(0)
                amount - inventoryQuantity
            } else amount

            if (needQuantity > 0) {
                val recipe = recipes.first { it.targetIngredient.material == material }
                val iterations: Int = kotlin.math.ceil(needQuantity.toDouble() / recipe.first).toInt()
                val actuallyProduced = recipe.first * iterations
                if (needQuantity < actuallyProduced) {
                    // Put excess in inventory
                    inventory[material] = inventory.getOrDefault(material, 0) + actuallyProduced - needQuantity
                }
                // Go produce each of our dependencies
                recipe.ingredients.map { calculateCost(it.second, it.first * iterations, inventory) }.sum()
            } else {
                0
            }
        }
    }

    fun goldExercise(): Long {
        return 0
    }
}

fun main() {
    val exc14 = Exercise14("/input14.txt")
    println("The answer to the silver exercise is ${exc14.silverExercise()}")
    println("The answer to the silver exercise is ${exc14.goldExercise()}")
}

data class Recipe(
        val targetIngredient: Ingredient,
        val ingredients: List<Ingredient>
)

data class Ingredient(
        val amount: Long,
        val material: String
)