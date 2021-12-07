package to.bri.aoc2021

// part 1
fun Iterable<Int>.countIncreases(): Int {
    return windowed(2).count { (a, b) -> a < b }
}

// part 2
fun Iterable<Int>.countIncreasesInSlidingWindow(): Int {
    return windowed(3).map { it.sum() }.countIncreases()
}
