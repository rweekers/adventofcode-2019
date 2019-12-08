package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise08Test {

    @Test
    fun `exercise 8 silver test`() {
        val exc8 = Exercise08("/test08-silver.txt", 3, 2)
        assertThat(exc8.silverExercise()).isEqualTo(1)
    }

    @Test
    fun `exercise 8 gold test`() {
        Exercise08("/test08-gold.txt", 2, 2).goldExercise()
        // just used for checking picture, no assert
    }
}
