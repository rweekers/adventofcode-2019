package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise01Test {

    @Test
    fun `exercise 1 silver test`() {
        val exc1 = Exercise01("/test01s.txt")
        assertThat(exc1.silverExercise()).isEqualTo(0)
    }

    @Test
    fun `exercise 1-1 gold test`() {
        val exc1 = Exercise01("/test01g.txt")
        assertThat(exc1.silverExercise()).isEqualTo(0)
    }
}
