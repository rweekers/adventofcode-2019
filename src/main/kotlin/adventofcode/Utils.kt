package adventofcode

internal object Utils

fun resourceAsListOfString(fileName: String): List<String> =
        Utils.javaClass.getResource(fileName).openStream().bufferedReader()
                .readLines()

fun resourceAsListOfLong(fileName: String): List<Long> =
        resourceAsListOfString(fileName).map { it.toLong() }