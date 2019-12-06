package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise04Test {

    @Test
    fun `exercise 4 silver test`() {
        val exc4 = Exercise04()
        assertThat(exc4.hasAtLeastTwoSubsequentEqualDigits(111111.toListOfInt())).isEqualTo(true)
        assertThat(exc4.allDigitsIncreasingOrEqual(111111.toListOfInt())).isEqualTo(true)

        assertThat(exc4.hasAtLeastTwoSubsequentEqualDigits(223450.toListOfInt())).isEqualTo(true)
        assertThat(exc4.allDigitsIncreasingOrEqual(223450.toListOfInt())).isEqualTo(false)

        assertThat(exc4.hasAtLeastTwoSubsequentEqualDigits(123789.toListOfInt())).isEqualTo(false)
        assertThat(exc4.allDigitsIncreasingOrEqual(123789.toListOfInt())).isEqualTo(true)
    }

    @Test
    fun `exercise 4 gold test`() {
        val exc4 = Exercise04()
        assertThat(exc4.hasExactlyTwoSubsequentEqualDigits(112233.toListOfInt())).isEqualTo(true)
        assertThat(exc4.allDigitsIncreasingOrEqual(112233.toListOfInt())).isEqualTo(true)

        assertThat(exc4.hasExactlyTwoSubsequentEqualDigits(123444.toListOfInt())).isEqualTo(false)
        assertThat(exc4.allDigitsIncreasingOrEqual(123444.toListOfInt())).isEqualTo(true)

        assertThat(exc4.hasExactlyTwoSubsequentEqualDigits(111122.toListOfInt())).isEqualTo(true)
        assertThat(exc4.allDigitsIncreasingOrEqual(111122.toListOfInt())).isEqualTo(true)

        // TODO extend that it copes with test below
        // assertThat(exc4.hasExactlyTwoSubsequentEqualDigits(222122.toListOfInt())).isEqualTo(true)
    }
}
