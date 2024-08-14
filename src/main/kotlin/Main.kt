import com.thoughtworks.kotlin_basic.util.ColumnLabelGenerator
import com.thoughtworks.kotlin_basic.util.PrintUtil

fun main(args: Array<String>) {
    val generator = ColumnLabelGenerator()

    while (true) {
        println("Enter the starting sequence number (or type 'end' to quit):")
        val startInput = readLine()
        if (startInput.equals("end", ignoreCase = true)) {
            println("Program terminated.")
            break
        }

        val start = startInput?.toIntOrNull()
        if (start == null || start <= 0) {
            println("Invalid input. Please enter a valid number greater than zero.")
            continue
        }

        println("Enter the number of results (or type 'end' to quit):")
        val countInput = readLine()
        if (countInput.equals("end", ignoreCase = true)) {
            println("Program terminated.")
            break
        }

        val count = countInput?.toIntOrNull()
        if (count == null || count <= 0) {
            println("Invalid input. Please enter a valid number greater than zero.")
            continue
        }

        try {
            val result = generator.generateColumnLabels(start, count)
            println("Column labels starting from $start for $count results:")
            println(result.joinToString(prefix = "[", postfix = "]"))
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
        }
    }
}

