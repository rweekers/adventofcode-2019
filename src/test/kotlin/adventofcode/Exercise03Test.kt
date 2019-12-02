package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise03Test {

    @Test
    fun `exercise 3 silver test`() {
        val exc3 = Exercise03("/test03.txt")
        assertThat(exc3.silverExercise()).isEqualTo(0)
    }

    @Test
    fun `exercise 3 gold test`() {
        val exc3 = Exercise03("/test03.txt")
        assertThat(exc3.goldExercise()).isEqualTo(0)
    }
}
