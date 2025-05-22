package utilities

import org.junit.Test
import kotlin.test.assertEquals

class CountOccurrencesTest {
    
    //countOccurrences encapsulates the logic for counting element occurrences in a list.
    fun <T> countOccurrences(input: List<T>): Map<T, Int> {
        return input.groupingBy { it }.eachCount()
    }

    @Test
    fun `countOccurrences handles empty list`() {
        val input = listOf<Int>()
        val result = countOccurrences(input)
        assertEquals(emptyMap(), result)
    }

    @Test
    fun `countOccurrences handles single element list`() {
        val input = listOf(1)
        val result = countOccurrences(input)
        assertEquals(mapOf(1 to 1), result)
    }


    @Test
    fun `countOccurrences handles list with multiple elements`() {
        val input = listOf(1, 2, 2, 3, 1, 1)
        val result = countOccurrences(input)
        assertEquals(mapOf(1 to 3, 2 to 2, 3 to 1), result)
    }

    // tests for multiple elements with also null values
    @Test
    fun `countOccurrences handles list with null values`() {
    val input = listOf(1, 2, null, 2, 1, null)
    val result = countOccurrences(input)
    assertEquals(mapOf(1 to 2, 2 to 2, null to 2), result)
}


    @Test
    fun `countOccurrences handles empty list of strings`() {
        val input = listOf<String>()
        val result = countOccurrences(input)
        assertEquals(emptyMap(), result)
    }

}
