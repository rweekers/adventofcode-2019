package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise02Test {

    @Test
    fun `exercise 2 silver test`() {
        val exc2 = Exercise02("/test02.txt")
        assertThat(exc2.silverExercise()).isEqualTo(0)
    }

    @Test
    fun `exercise 2 gold test`() {
        val exc2 = Exercise02("/test02.txt")
        assertThat(exc2.goldExercise()).isEqualTo(0)
    }
}
