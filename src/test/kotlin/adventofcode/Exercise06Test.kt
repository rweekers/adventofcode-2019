package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise06Test {

    @Test
    fun `exercise 6 silver test`() {
        val exc6 = Exercise06("/test06-silver.txt")
        assertThat(exc6.silverExercise()).isEqualTo(42)
    }

    @Test
    fun `exercise 6 gold test`() {
        val exc6 = Exercise06("/test06-gold.txt")
        assertThat(exc6.goldExercise()).isEqualTo(4)
    }
}
