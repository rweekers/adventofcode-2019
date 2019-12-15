package adventofcode

import kotlin.math.absoluteValue

data class Moon(
        var position: Position,
        var velocity: Velocity,
        val kineticEnergy: Int = position.energy.times(velocity.energy)
) {
    fun processStep(otherMoons: List<Moon>): Moon {
        // adjust velocity
        val deltaX = otherMoons.filter { otherMoon -> otherMoon.position.x > this.position.x }.count() - otherMoons.filter { otherMoon -> otherMoon.position.x < this.position.x }.count()
        val deltaY = otherMoons.filter { otherMoon -> otherMoon.position.y > this.position.y }.count() - otherMoons.filter { otherMoon -> otherMoon.position.y < this.position.y }.count()
        val deltaZ = otherMoons.filter { otherMoon -> otherMoon.position.z > this.position.z }.count() - otherMoons.filter { otherMoon -> otherMoon.position.z < this.position.z }.count()

        val newVelocity = Velocity(velocity.x + deltaX, velocity.y + deltaY, velocity.z + deltaZ)

        val newPosition = Position(position.x + newVelocity.x, position.y + newVelocity.y, position.z + newVelocity.z)

        return Moon(newPosition, newVelocity)
    }
}

data class Position(
        val x: Int,
        val y: Int,
        val z: Int,
        val energy: Int = x.absoluteValue + y.absoluteValue + z.absoluteValue
)

data class Velocity(
        val x: Int = 0,
        val y: Int = 0,
        val z: Int = 0,
        val energy: Int = x.absoluteValue + y.absoluteValue + z.absoluteValue
)