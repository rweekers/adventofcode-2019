package adventofcode

internal object Utils

fun resourceAsListOfString(fileName: String): List<String> =
        Utils.javaClass.getResource(fileName).openStream().bufferedReader()
                .readLines()

fun resourceAsListOfLong(fileName: String): List<Long> =
        resourceAsListOfString(fileName).map { it.toLong() }

fun lineAsListOfInts(fileName: String): List<Int> =
        Utils.javaClass.getResource(fileName).openStream().bufferedReader().readLine().split(",").map { it.toInt() }

fun lineAsListOfStrings(fileName: String, index: Int): List<String> =
        Utils.javaClass.getResource(fileName).openStream().bufferedReader().readLines()[index].split(",")