package to.bri.aoc2021

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFailure
import assertk.assertions.isInstanceOf
import assertk.assertions.prop
import org.junit.jupiter.api.Test

class Day02Test {

    @Test
    fun `move submarine without aim forward`() {
        val command = Forward(1)
        val sub = SubmarineWithoutAim()(command)
        assertThat(sub.position).isEqualTo(1)
        assertThat(sub.depth).isEqualTo(0)
    }

    @Test
    fun `move submarine without aim down`() {
        val command = Down(1)
        val sub = SubmarineWithoutAim()(command)
        assertThat(sub.position).isEqualTo(0)
        assertThat(sub.depth).isEqualTo(1)
    }

    @Test
    fun `move submarine without aim up`() {
        val command = Up(1)
        val sub = SubmarineWithoutAim()(command)
        assertThat(sub.position).isEqualTo(0)
        assertThat(sub.depth).isEqualTo(-1)
    }

    @Test
    fun `parse line with too few parts`() {
        assertThat { SubmarineCommand.parse("too_few_parts") }
            .isFailure()
            .isInstanceOf(IllegalArgumentException::class)
    }

    @Test
    fun `parse line with too many parts`() {
        assertThat { SubmarineCommand.parse("too many parts") }
            .isFailure()
            .isInstanceOf(IllegalArgumentException::class)
    }

    @Test
    fun `parse line with invalid value`() {
        assertThat { SubmarineCommand.parse("invalid value") }
            .isFailure()
            .isInstanceOf(IllegalArgumentException::class)
    }

    @Test
    fun `parse line with invalid command`() {
        assertThat { SubmarineCommand.parse("command 0") }
            .isFailure()
            .isInstanceOf(IllegalArgumentException::class)
    }

    @Test
    fun `parse line forward`() {
        assertThat(SubmarineCommand.parse("forward 1"))
            .isInstanceOf(Forward::class)
            .prop(Forward::value).isEqualTo(1)
    }

    @Test
    fun `parse line down`() {
        assertThat(SubmarineCommand.parse("down 1"))
            .isInstanceOf(Down::class)
            .prop(Down::value).isEqualTo(1)
    }

    @Test
    fun `parse line up`() {
        assertThat(SubmarineCommand.parse("up 1"))
            .isInstanceOf(Up::class)
            .prop(Up::value).isEqualTo(1)
    }

    @Test
    fun `drive submarine without aim`() {
        val lines = readLines("input-02.txt")
        val sub = SubmarineDriver.drive(SubmarineWithoutAim(), lines)
        assertThat(sub.position * sub.depth).isEqualTo(2322630)
    }

    @Test
    fun `drive submarine with aim`() {
        val lines = readLines("input-02.txt")
        val sub = SubmarineDriver.drive(SubmarineWithAim(), lines)
        assertThat(sub.position * sub.depth).isEqualTo(2105273490)
    }
}
