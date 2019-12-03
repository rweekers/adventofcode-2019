package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise04Test {

    @Test
    fun `exercise 4 silver test`() {
        val exc4 = Exercise04("/test04.txt")
        assertThat(exc4.silverExercise()).isEqualTo(0)
    }

    @Test
    fun `exercise 4 gold test`() {
        val exc4 = Exercise04("/test04.txt")
        assertThat(exc4.goldExercise()).isEqualTo(0)
    }
}
