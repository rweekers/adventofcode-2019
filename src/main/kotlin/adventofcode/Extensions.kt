package adventofcode

fun <T> List<T>.innerJoin(otherList: List<T>): List<T> {
    return this.filter { otherList.contains(it) }
}