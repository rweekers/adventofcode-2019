package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise03Test {

    @Test
    fun `exercise 3-1 silver test`() {
        val exc3 = Exercise03("/test03-1.txt")
        assertThat(exc3.silverExercise()).isEqualTo(6)
    }

    @Test
    fun `exercise 3-2 silver test`() {
        val exc3 = Exercise03("/test03-2.txt")
        assertThat(exc3.silverExercise()).isEqualTo(159)
    }

    @Test
    fun `exercise 3-3 silver test`() {
        val exc3 = Exercise03("/test03-3.txt")
        assertThat(exc3.silverExercise()).isEqualTo(135)
    }

    @Test
    fun `exercise 3-1 gold test`() {
        val exc3 = Exercise03("/test03-1.txt")
        assertThat(exc3.goldExercise()).isEqualTo(30)
    }

    @Test
    fun `exercise 3-2 gold test`() {
        val exc3 = Exercise03("/test03-2.txt")
        assertThat(exc3.goldExercise()).isEqualTo(610)
    }

    @Test
    fun `exercise 3-3 gold test`() {
        val exc3 = Exercise03("/test03-3.txt")
        assertThat(exc3.goldExercise()).isEqualTo(410)
    }
}
