package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise05Test {

    @Test
    fun `exercise 5 silver actual answer`() {
        val exc5 = Exercise05("/input05.txt")
        assertThat(exc5.silverExercise()).isEqualTo(9775037)
    }

    @Test
    fun `exercise 5 gold actual answer`() {
        val exc5 = Exercise05("/input05.txt")
        assertThat(exc5.goldExercise()).isEqualTo(15586959)
    }
}
