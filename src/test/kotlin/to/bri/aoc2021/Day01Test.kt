package to.bri.aoc2021

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class Day01KtTest {

    @Test
    fun `day 01, part 1`() {
        assertThat(readInts("input-01.txt").countIncreases()).isEqualTo(1482)
    }

    @Test
    fun `day 01, part 2`() {
        assertThat(readInts("input-01.txt").countIncreasesInSlidingWindow()).isEqualTo(1518)
    }

}
