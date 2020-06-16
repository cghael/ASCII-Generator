package signature

import java.io.File
import java.util.*

fun getInputData (): Array<String> {
    val input = arrayOf("", "")
    print("Enter name and surname: ")
    input[0] = readLine()!!
    print("Enter person's status: ")
    input[1] = readLine()!!.toLowerCase()
    return input
}

fun createNameStrings (letters: Array<Array<String>>, name: String): Array<String> {
    val nameToPrint = Array(3) { "" }
    for (ch in name) {
        for (i in letters[0].indices) {
            if (ch == ' ') {
                nameToPrint[i] += " ".repeat(5)
            } else {
                nameToPrint[i] += letters[ch - 'a'][i]
            }
        }
    }
    return nameToPrint
}

fun createAllStrings(name: Array<String>, status: Array<String>): Array<String> {
    val stringsToPrint = Array(15) { "" }
    if (name[0].length < status[0].length) {
        for (i in name.indices) {
            stringsToPrint[i + 1] = " ".repeat((status[0].length - name[i].length) / 2) + name[i] +
                    " ".repeat((status[0].length - name[i].length) / 2 +
                            (status[0].length - name[i].length) % 2)
        }
        for (i in status.indices) {
            stringsToPrint[i + 11] = status[i]
        }
    } else {
        for (i in name.indices) {
            stringsToPrint[i + 1] = name[i]
        }
        for (i in status.indices) {
            stringsToPrint[i + 11] = " ".repeat((name[0].length - status[i].length) / 2) + status[i] +
                    " ".repeat((name[0].length - status[i].length) / 2 + (name[0].length - status[i].length) % 2)
        }
    }
    val length = stringsToPrint[4].length + 8
    for (i in stringsToPrint.indices) {
        if (i == 0 || i == stringsToPrint.size - 1) {
            stringsToPrint[i] = "8".repeat(length)
        } else {
            stringsToPrint[i] = "88  " + stringsToPrint[i] + "  88"
        }
    }
    return stringsToPrint
}

fun createRomanStrings (name: String): Array<String> {
    val romanToPrint = Array(10) { "" }
    for (ch in name) {
        if (ch == ' ') {
            for (i in 0 until 10) romanToPrint[i] += " ".repeat(10)
            continue
        }
        val inputRoman = Scanner(File("roman.txt"))
        while (inputRoman.hasNext()) {
            val fileStr = inputRoman.nextLine()
            if (fileStr[0] == ch && fileStr[1] == ' ') {
                val width = fileStr.substring(2).toInt()
                for (i in 0 until 10) {
                    romanToPrint[i] += inputRoman.nextLine().substring(0, width)
                }
                break
            }
        }
    }
    return (romanToPrint)
}

fun main() {
    val letters = arrayOf(
            arrayOf("____ ", "|__| ", "|  | "),     // A
            arrayOf("___  ", "|__] ", "|__] "),     // B
            arrayOf("____ ", "|    ", "|___ "),     // C
            arrayOf("___  ", "|  \\ ", "|__/ "),    // D
            arrayOf("____ ", "|___ ", "|___ "),     // E
            arrayOf("____ ", "|___ ", "|    "),     // F
            arrayOf("____ ", "| __ ", "|__] "),     // G
            arrayOf("_  _ ", "|__| ", "|  | "),     // H
            arrayOf("_ ", "| ", "| "),              // I
            arrayOf(" _ ", " | ", "_| "),           // J
            arrayOf("_  _ ", "|_/  ", "| \\_ "),    // K
            arrayOf("_    ", "|    ", "|___ "),     // L
            arrayOf("_  _ ", "|\\/| ", "|  | "),    // M
            arrayOf("_  _ ", "|\\ | ", "| \\| "),   // N
            arrayOf("____ ", "|  | ", "|__| "),     // O
            arrayOf("___  ", "|__] ", "|    "),     // P
            arrayOf("____ ", "|  | ", "|_\\| "),    // Q
            arrayOf("____ ", "|__/ ", "|  \\ "),    // R
            arrayOf("____ ", "[__  ", "___] "),     // S
            arrayOf("___ ", " |  ", " |  "),        // T
            arrayOf("_  _ ", "|  | ", "|__| "),     // U
            arrayOf("_  _ ", "|  | ", " \\/  "),    // V
            arrayOf("_ _ _ ", "| | | ", "|_|_| "),  // W
            arrayOf("_  _ ", " \\/  ", "_/\\_ "),   // X
            arrayOf("_   _ ", " \\_/  ", "  |   "), // Y
            arrayOf("___  ", "  /  ", " /__ ")      // Z
    )
    val input = getInputData()
    val romanToPrint = createRomanStrings(input[0])
    val statusToPrint = createNameStrings(letters, input[1])
    val stringsToPrint = createAllStrings(romanToPrint, statusToPrint)
    for (i in stringsToPrint.indices) println(stringsToPrint[i])
}
