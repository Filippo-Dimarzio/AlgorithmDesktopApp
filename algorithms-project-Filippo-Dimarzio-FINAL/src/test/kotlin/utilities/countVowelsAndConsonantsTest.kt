package utilities


import org.junit.Test
import kotlin.test.assertEquals

class CountVowelsAndConsonantsTest {

    @Test
    fun `countVowelsAndConsonants handles empty string`() {
        val input = ""
        val result = countVowelsAndConsonantsLinear(input)
        assertEquals(Pair(0, 0), result)
    }

    @Test
    fun `countVowelsAndConsonants handles string with only vowels`() {
        val input = "aeiou"
        val result = countVowelsAndConsonantsLinear(input)
        assertEquals(Pair(5, 0), result)
    }

    @Test
    fun `countVowelsAndConsonants handles string with only consonants`() {
        val input = "bcdfgh"
        val result = countVowelsAndConsonantsLinear(input)
        assertEquals(Pair(0, 6), result)
    }

    @Test
    fun `countVowelsAndConsonants handles mixed string`() {
        val input = "Broke a connie machine"
        val result = countVowelsAndConsonantsLinear(input)
        assertEquals(Pair(9, 10), result)
    }

}
