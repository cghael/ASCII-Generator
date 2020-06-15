package signature

fun getInputData (): Array<String> {
    val input = arrayOf("", "")
    print("Enter name and surname: ")
    input[0] = readLine()!!.toLowerCase()
    print("Enter person's status: ")
    input[1] = readLine()!!
    return input
}

fun createNameStrings (letters: Array<Array<String>>, name: String): Array<String> {
    val nameToPrint = arrayOf("", "", "")
    for (j in name.indices) {
        for (i in letters[0].indices) {
            if (name[j] == ' ') {
                nameToPrint[i] += " ".repeat(5)
            } else {
                nameToPrint[i] += letters[name[j] - 'a'][i]
                if (j != name.lastIndex) nameToPrint[i] += " "
            }
        }
    }
    return nameToPrint
}

fun createAllStrings(nameToPrint: Array<String>, status: String): Array<String> {
    val stringsToPrint = arrayOf("", "", "", "", "", "")
    if (nameToPrint[0].length < status.length) {
        for (i in nameToPrint.indices) {
            stringsToPrint[i + 1] = " ".repeat((status.length - nameToPrint[i].length) / 2) + nameToPrint[i] +
                    " ".repeat((status.length - nameToPrint[i].length) / 2 +
                            (status.length - nameToPrint[i].length) % 2)
        }
        stringsToPrint[4] = status
    } else {
        for (i in nameToPrint.indices) {
            stringsToPrint[i + 1] = nameToPrint[i]
        }
        stringsToPrint[4] = " ".repeat((nameToPrint[0].length - status.length) / 2) + status +
                " ".repeat((nameToPrint[0].length - status.length) / 2 + (nameToPrint[0].length - status.length) % 2)
    }
    val length = stringsToPrint[4].length + 6
    for (i in 0..5) {
        if (i == 0 || i == 5) {
            stringsToPrint[i] = "*".repeat(length)
        } else {
            stringsToPrint[i] = "*  " + stringsToPrint[i] + "  *"
        }
    }
    return stringsToPrint
}

fun main() {
    val letters = arrayOf(
            arrayOf("____", "|__|", "|  |"),     // A
            arrayOf("___ ", "|__]", "|__]"),     // B
            arrayOf("____", "|   ", "|___"),     // C
            arrayOf("___ ", "|  \\", "|__/"),    // D
            arrayOf("____", "|___", "|___"),     // E
            arrayOf("____", "|___", "|   "),     // F
            arrayOf("____", "| __", "|__]"),     // G
            arrayOf("_  _", "|__|", "|  |"),     // H
            arrayOf("_", "|", "|"),              // I
            arrayOf(" _", " |", "_|"),           // J
            arrayOf("_  _", "|_/ ", "| \\_"),    // K
            arrayOf("_   ", "|   ", "|___"),     // L
            arrayOf("_  _", "|\\/|", "|  |"),    // M
            arrayOf("_  _", "|\\ |", "| \\|"),   // N
            arrayOf("____", "|  |", "|__|"),     // O
            arrayOf("___ ", "|__]", "|   "),     // P
            arrayOf("____", "|  |", "|_\\|"),    // Q
            arrayOf("____", "|__/", "|  \\"),    // R
            arrayOf("____", "[__ ", "___]"),     // S
            arrayOf("___", " | ", " | "),        // T
            arrayOf("_  _", "|  |", "|__|"),     // U
            arrayOf("_  _", "|  |", " \\/ "),    // V
            arrayOf("_ _ _", "| | |", "|_|_|"),  // W
            arrayOf("_  _", " \\/ ", "_/\\_"),   // X
            arrayOf("_   _", " \\_/ ", "  |  "), // Y
            arrayOf("___ ", "  / ", " /__")      // Z
    )
    val input = getInputData()
    val nameToPrint = createNameStrings(letters, input[0])
    val stringsToPrint = createAllStrings(nameToPrint, input[1])
    for (i in stringsToPrint.indices) println(stringsToPrint[i])
}