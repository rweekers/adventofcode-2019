package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise07Test {

    @Test
    fun `exercise 7 silver test - 1`() {
        val exc7 = Exercise07("/test07-1.txt")
        assertThat(exc7.silverExercise()).isEqualTo(43210) // from phase setting sequence 4,3,2,1,0
    }

    @Test
    fun `exercise 7 silver test - 2`() {
        val exc7 = Exercise07("/test07-2.txt")
        assertThat(exc7.silverExercise()).isEqualTo(54321) // from phase setting sequence 0,1,2,3,4
    }

    @Test
    fun `exercise 7 silver test - 3`() {
        val exc7 = Exercise07("/test07-3.txt")
        assertThat(exc7.silverExercise()).isEqualTo(65210) // from phase setting sequence 1,0,4,3,2
    }

    @Test
    fun `exercise 7 gold test`() {
        val exc7 = Exercise07("/test07-gold.txt")
        assertThat(exc7.goldExercise()).isEqualTo(0)
    }
}
