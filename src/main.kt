package signature

import java.util.*

fun printHeadLine (length: Int) {
    repeat(length) {
        print("*")
    }
    print("\n")
}
/*
fun printLowLine (length: Int) {
    print(" ")
    repeat(length - 2) {
        print("¯")
    }
}
*/
fun main() {
    val scanner = Scanner(System.`in`)
    val firstName = scanner.next()
    val secondName = scanner.next()
    val fullNameLine = "* $firstName $secondName *"
    printHeadLine(fullNameLine.length)
    println(fullNameLine)
    printHeadLine(fullNameLine.length)
}