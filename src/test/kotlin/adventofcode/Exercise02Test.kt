package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise02Test {

    @Test
    fun `exercise 2-1 silver test`() {
        val exc1 = Exercise02("/test02-1.txt")
        assertThat(exc1.silverExercise()).isEqualTo(2)
    }

    @Test
    fun `exercise 2-2 silver test`() {
        val exc1 = Exercise02("/test02-2.txt")
        assertThat(exc1.silverExercise()).isEqualTo(2)
    }

    @Test
    fun `exercise 2-3 silver test`() {
        val exc1 = Exercise02("/test02-3.txt")
        assertThat(exc1.silverExercise()).isEqualTo(2)
    }

    @Test
    fun `exercise 2-4 silver test`() {
        val exc1 = Exercise02("/test02-4.txt")
        assertThat(exc1.silverExercise()).isEqualTo(30)
    }
}
