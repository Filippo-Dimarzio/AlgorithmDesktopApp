package utilities

import mostFrequentElementMap
import org.junit.Test
import kotlin.test.assertEquals


class MostFrequentElementTest {

    @Test
    fun `mostFrequentElementMap handles empty list`() {
        val input = listOf<Int>()
        val result = mostFrequentElementMap(input)
        assertEquals(null, result)
    }

    @Test
    fun `mostFrequentElementMap handles single element list`() {
        val input = listOf(3)
        val result = mostFrequentElementMap(input)
        assertEquals(1, result)
    }

    @Test
    fun `mostFrequentElementMap handles list with multiple elements`() {
        val input = listOf(1, 2, 3, 2, 1, 1)
        val result = mostFrequentElementMap(input)
        assertEquals(1, result)
    }



}

