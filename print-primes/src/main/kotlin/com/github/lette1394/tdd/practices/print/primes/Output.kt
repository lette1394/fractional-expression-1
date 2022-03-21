package com.github.lette1394.tdd.practices.print.primes

import java.io.PrintStream

class Output(
    private val printStream: PrintStream,
) {
    fun println(string: String) = printStream.println(string)

    fun printLineBreak() = println("")

    fun printPageBreak() = println("\u000c")

    fun printFormatted(int: Int) {
        printStream.format("%10d", int)
    }
}
