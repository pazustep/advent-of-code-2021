package to.bri.aoc2021

fun readInts(resource: String) =
    Thread.currentThread().contextClassLoader
        .getResourceAsStream(resource)!!
        .bufferedReader()
        .readLines()
        .map { it.toInt() }
