package utilities

fun vowelsAndConsonants(str: String): Pair<Int, Int> {
    var vowelsCount = 0
    var consonantsCount = 0
    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

    for (char in str) {
        if (char.isLetter()) {
            if (char in vowels) {
                vowelsCount++
            } else {
                consonantsCount++
            }
        }
    }
    return Pair(vowelsCount, consonantsCount)
}


