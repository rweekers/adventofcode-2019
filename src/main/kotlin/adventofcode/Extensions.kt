package adventofcode

import kotlin.math.pow

fun <T> List<T>.innerJoin(otherList: List<T>): List<T> {
    return this.filter { otherList.contains(it) }
}

fun Int.toListOfInt(): List<Int> {
    return this.toString().map { it.toString().toInt() }
}

fun Int.takeLastN(n: Int): Int {
    return this.toString().takeLast(n).toInt()
}

fun Int.dropLastN(n: Int): Int {
    return this.toString().dropLast(n).toInt()
}

fun Int.parameterMode(postion: Int): Int {
    return this / (10.0.pow(postion).toInt()) % 10
}

fun String.toListOfInt(): List<Int> {
    return this.split(",").map { it.toInt() }
}