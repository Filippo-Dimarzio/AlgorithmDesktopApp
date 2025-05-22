fun mostFrequentElementMap(inputList: List<Int>): Any? {

    if (inputList.isEmpty()) return null

    val frequencyMap = mutableMapOf<Int, Int>()
    for (item in inputList) {
        frequencyMap[item] = (frequencyMap[item] ?: 0) + 1
    }

    if (frequencyMap.size == 1) return frequencyMap.entries.first().value

    var mostFrequentElement: Int? = null
    var maxCount = 0

    for (entry in frequencyMap) {
        if (entry.value > maxCount) {
            maxCount = entry.value
            mostFrequentElement = entry.key
        }
    }

    return mostFrequentElement
}
