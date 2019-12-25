package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise14Test {

    @Test
    fun `exercise 14-1 silver test`() {
        val exc14 = Exercise14("/test14-1.txt")
        assertThat(exc14.silverExercise()).isEqualTo(0)
    }

    @Test
    fun `exercise 14 gold test`() {
        val exc14 = Exercise14("/test14-1.txt")
        assertThat(exc14.goldExercise()).isEqualTo(0)
    }
}
