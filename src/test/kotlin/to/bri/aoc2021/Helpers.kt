package to.bri.aoc2021

fun readLines(resource: String) =
    Thread.currentThread().contextClassLoader
        .getResourceAsStream(resource)!!
        .bufferedReader()
        .readLines()

fun readInts(resource: String) =
    readLines(resource).map { it.toInt() }
