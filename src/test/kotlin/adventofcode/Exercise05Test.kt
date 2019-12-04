package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise05Test {

    @Test
    fun `exercise 5 silver test`() {
        // Adding 99 to the end to make sure the test ends
        val exc5 = Exercise05("/test05.txt")
        assertThat(exc5.silverExercise()).isEqualTo(0)
    }

    @Test
    fun `exercise 5 gold test`() {
        val exc5 = Exercise05("/test05.txt")
        assertThat(exc5.goldExercise()).isEqualTo(0)
    }
}
