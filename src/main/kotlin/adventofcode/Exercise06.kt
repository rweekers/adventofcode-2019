package adventofcode

import java.lang.RuntimeException

class Exercise06(input: String) {

    private val inputList = resourceAsListOfString(input)
    private val planetMap = mutableMapOf<String, Node>()

    init {
        inputList
                .map { it.split(")") }
                .map { OrbitMap(it[0], it[1]) }
                .forEach { processOrbitMap(it) }
    }

    fun silverExercise(): Int {
        return planetMap.values.sumBy { it.getOrbitCount() }
    }

    private fun processOrbitMap(orbitMap: OrbitMap) {
        val orbitedNode = planetMap.getOrElse(orbitMap.orbitedPlanet) {
            val node = Node(orbitMap.orbitedPlanet)
            planetMap[orbitMap.orbitedPlanet] = node
            node
        }
        val orbitingNode = planetMap.getOrElse(orbitMap.orbitingPlanet) {
            val node = Node(orbitMap.orbitingPlanet, orbitedNode)
            planetMap[orbitMap.orbitingPlanet] = node
            node
        }
        orbitedNode.addSubNode(orbitingNode)
    }

    fun goldExercise(): Int {
        return planetMap["YOU"]?.getStepsToFirstSharedNode(planetMap["SAN"]!!)
                ?: throw RuntimeException("No shared node found")
    }

    private class OrbitMap(
            val orbitedPlanet: String,
            val orbitingPlanet: String
    ) {
        override fun toString(): String {
            return "Planet $orbitedPlanet is being orbited by $orbitingPlanet"
        }
    }

    private data class Node(val name: String, var parent: Node? = null, val subNodes: MutableList<Node> = mutableListOf()) {

        fun addSubNode(subNode: Node) {
            subNodes.add(subNode)
            subNode.parent = this
        }

        fun getParents(): List<Node> {
            val parents = mutableListOf<Node>()
            var parent = this.parent
            while (parent != null) {
                parents.add(parent)
                parent = parent.parent
            }
            return parents
        }

        fun getStepsToFirstSharedNode(otherNode: Node): Int {
            val join = this.getParents().innerJoin(otherNode.getParents())
            return join.map { this.getParents().indexOf(it) + otherNode.getParents().indexOf(it) }.min()!!
        }

        fun getOrbitCount(): Int {
            return getOrbitCount(0)
        }

        fun getOrbitCount(count: Int): Int {
            return parent?.getOrbitCount(count + 1) ?: count
        }

        override fun toString(): String {
            return "node $name with connections ${getOrbitCount()}"
        }
    }
}

fun main() {
    val exc6 = Exercise06("/input06.txt")
    println("The answer to the silver exercise is ${exc6.silverExercise()}")
    println("The answer to the gold exercise is ${exc6.goldExercise()}")
}
