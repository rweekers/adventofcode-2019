package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise10Test {

    @Test
    fun `check greatest common divider`() {
        val a = 81
        val b = 153

        assertThat(a.greatestCommonDivider(b)).isEqualTo(9)
    }

    @Test
    fun `exercise 10-1 silver test`() {
        val exc10 = Exercise10("/test10-1.txt")
        assertThat(exc10.silverExercise()).isEqualTo(8)
    }

    @Test
    fun `exercise 10-2 silver test`() {
        val exc10 = Exercise10("/test10-2.txt")
        assertThat(exc10.silverExercise()).isEqualTo(33)
    }

    @Test
    fun `exercise 10-3 silver test`() {
        val exc10 = Exercise10("/test10-3.txt")
        assertThat(exc10.silverExercise()).isEqualTo(35)
    }

    @Test
    fun `exercise 10-4 silver test`() {
        val exc10 = Exercise10("/test10-4.txt")
        assertThat(exc10.silverExercise()).isEqualTo(41)
    }

    @Test
    fun `exercise 10-5 silver test`() {
        val exc10 = Exercise10("/test10-5.txt")
        assertThat(exc10.silverExercise()).isEqualTo(210)
    }

    @Test
    fun `exercise 10 gold test`() {
        val exc10 = Exercise10("/test10-5.txt")
        assertThat(exc10.goldExercise()).isEqualTo(802)
    }
}
