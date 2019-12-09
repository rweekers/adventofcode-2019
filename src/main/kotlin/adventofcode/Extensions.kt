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

fun String.commaSeparatedToListOfInt(): List<Int> {
    return this.split(",").map { it.toInt() }
}

fun String.toListOfInt(): List<Int> {
    return this.toCharArray().map { it.toString().toInt() }
}

fun <T> List<T>.permutations(): List<List<T>> =
        if (this.size <= 1) listOf(this)
        else {
            val elementToInsert = first()
            drop(1).permutations().flatMap { permutation ->
                (0..permutation.size).map { i ->
                    permutation.toMutableList().apply { add(i, elementToInsert) }
                }
            }
        }

fun String.toListOfSingleStrings(): List<String> {
    return this.toCharArray().map { it.toString() }
}

fun Int.greatestCommonDivider(otherInt: Int): Int {
    var n1 = this
    var n2 = otherInt
    while (n1 != n2) {
        if (n1 > n2)
            n1 -= n2
        else
            n2 -= n1
    }
    return n1
}

fun <T> List<T>.everyPair(): List<Pair<T, T>> =
        this.mapIndexed { idx, left ->
            this.drop(idx+1).map { right ->
                Pair(left, right)
            }
        }.flatten()