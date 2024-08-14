package com.thoughtworks.kotlin_basic.util
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ColumnLabelGeneratorTest {
    private val generator = ColumnLabelGenerator()

    @Test
    fun testGenerateColumnLabels() {
        assertArrayEquals(arrayOf("A"), generator.generateColumnLabels(1, 1))
        assertArrayEquals(arrayOf("A", "B"), generator.generateColumnLabels(1, 2))
        assertArrayEquals(arrayOf("Z", "AA", "AB"), generator.generateColumnLabels(26, 3))
        assertArrayEquals(arrayOf("ZY", "ZZ", "AAA"), generator.generateColumnLabels(701, 3))
        assertArrayEquals(arrayOf("ZZZ"), generator.generateColumnLabels(18278, 1))
    }

    @Test
    fun testGenerateColumnLabelsInvalidInputs() {
        assertThrows(IllegalArgumentException::class.java) {
            generator.generateColumnLabels(0, 1)
        }
        assertThrows(IllegalArgumentException::class.java) {
            generator.generateColumnLabels(1, 0)
        }
        assertThrows(IllegalArgumentException::class.java) {
            generator.generateColumnLabels(-1, 1)
        }
        assertThrows(IllegalArgumentException::class.java) {
            generator.generateColumnLabels(1, -1)
        }
        assertThrows(IllegalArgumentException::class.java) {
            generator.generateColumnLabels(0, 0)
        }
        assertThrows(IllegalArgumentException::class.java) {
            generator.generateColumnLabels(18279, 1)
        }
        assertThrows(IllegalArgumentException::class.java) {
            generator.generateColumnLabels(1, 18279)
        }

    }

    @Test
    fun testNumberToColumnLabel() {
        assertEquals("A", generator.generateColumnLabels(1, 1)[0])
        assertEquals("Z", generator.generateColumnLabels(26, 1)[0])
        assertEquals("AA", generator.generateColumnLabels(27, 1)[0])
        assertEquals("AZ", generator.generateColumnLabels(52, 1)[0])
        assertEquals("BA", generator.generateColumnLabels(53, 1)[0])
        assertEquals("ZZ", generator.generateColumnLabels(702, 1)[0])
        assertEquals("AAA", generator.generateColumnLabels(703, 1)[0])
    }
}