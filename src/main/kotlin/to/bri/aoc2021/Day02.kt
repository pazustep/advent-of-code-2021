package to.bri.aoc2021

sealed interface Submarine<T : Submarine<T>> {
    operator fun invoke(command: SubmarineCommand): T
}

// part 1
data class SubmarineWithoutAim(val position: Int = 0, val depth: Int = 0) : Submarine<SubmarineWithoutAim> {
    override fun invoke(command: SubmarineCommand) = when (command) {
        is Forward -> copy(position = position + command.value)
        is Down -> copy(depth = depth + command.value)
        is Up -> copy(depth = depth - command.value)
    }
}

// part 2
data class SubmarineWithAim(val position: Int = 0, val depth: Int = 0, val aim: Int = 0) : Submarine<SubmarineWithAim> {
    override fun invoke(command: SubmarineCommand) = when (command) {
        is Forward -> copy(position = position + command.value, depth = depth + (command.value * aim))
        is Down -> copy(aim = aim + command.value)
        is Up -> copy(aim = aim - command.value)
    }
}

object SubmarineDriver {
    fun <T : Submarine<T>> drive(initial: T, lines: List<String>): T {
        return lines.asSequence()
            .map { SubmarineCommand.parse(it) }
            .fold(initial) { sub, command -> sub(command) }
    }
}

sealed interface SubmarineCommand {
    companion object {
        fun parse(line: String): SubmarineCommand {
            val parts = line.split(' ')
            if (parts.size != 2) throw IllegalArgumentException("invalid line: $line")

            val command = parts[0]
            val value = parts[1].toInt()

            return when (command) {
                "forward" -> Forward(value)
                "down" -> Down(value)
                "up" -> Up(value)
                else -> throw IllegalArgumentException("invalid line: $line")
            }
        }
    }
}

data class Forward(val value: Int) : SubmarineCommand
data class Down(val value: Int) : SubmarineCommand
data class Up(val value: Int) : SubmarineCommand
