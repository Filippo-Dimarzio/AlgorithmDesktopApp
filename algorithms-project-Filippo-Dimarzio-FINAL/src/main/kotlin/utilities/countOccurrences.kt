package utilities

fun countOccurrences(inputList: List<Any>): Map<Any, Int> {
    val occurrenceMap = mutableMapOf<Any, Int>()
    for (item in inputList) {
        occurrenceMap[item] = (occurrenceMap[item] ?: 0) + 1
    }
    return occurrenceMap
}
