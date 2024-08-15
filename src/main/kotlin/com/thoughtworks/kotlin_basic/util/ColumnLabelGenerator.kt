package com.thoughtworks.kotlin_basic.util

class ColumnLabelGenerator {

    fun generateColumnLabels(start: Int, count: Int): Array<String> {
        require(start > 0 && count > 0) { "Start and count must be greater than zero." }

        val maxLabelNumber = 18278 // The maximum number for label "ZZZ" is 18278

        if (start > maxLabelNumber || (start + count - 1) > maxLabelNumber) {
            throw IllegalArgumentException("Starting sequence number and count exceed the limit for column labels.")
        }

        return (start..<(start + count)).map { numberToColumnLabel(it) }.toTypedArray()
    }

    private fun numberToColumnLabel(number: Int): String {
        require(number > 0) { "Number must be greater than zero." }

        var n = number
        val label = StringBuilder()

        while (n > 0) {
            val remainder = (n - 1) % 26
            label.append(('A' + remainder))
            n = (n - 1) / 26
        }

        return label.reverse().toString()
    }
}