package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise12Test {

    @Test
    fun `exercise 12-1 silver test`() {
        val exc12 = Exercise12("/test12-1.txt")
        assertThat(exc12.silverExercise(10)).isEqualTo(179)
    }

    @Test
    fun `exercise 12-2 silver test`() {
        val exc12 = Exercise12("/test12-2.txt")
        assertThat(exc12.silverExercise(100)).isEqualTo(1940)
    }

    @Test
    fun `exercise 12-actual silver test`() {
        val exc12 = Exercise12("/input12.txt")
        assertThat(exc12.silverExercise(1000)).isEqualTo(12466)
    }

    @Test
    fun `exercise 12-1 gold test`() {
        val exc12 = Exercise12("/test12-1.txt")
        assertThat(exc12.goldExercise()).isEqualTo(2772)
    }

    @Test
    fun `exercise 12-actual gold test`() {
        val exc12 = Exercise12("/input12.txt")
        assertThat(exc12.goldExercise()).isEqualTo(360689156787864L)
    }
}
