package com.github.lette1394.tdd.practices.print.primes

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.StandardCharsets

class PrimeTextPage(
    private val printPrimes: PrintPrimes,
) {
    fun asString(): String {
        val M = 1000
        val byteArrayOutputStream = ByteArrayOutputStream()
        val output = Output(PrintStream(byteArrayOutputStream))
        var pageNumber = 1
        var pageOffset = 1
        var rowOffset = 0
        val RR = 50
        val CC = 4

        var c = 0
        while (pageOffset <= M) {
            output.println("The First $M Prime Numbers --- Page $pageNumber")
            output.printLineBreak()

            rowOffset = pageOffset
            while (rowOffset < pageOffset + RR) {
                c = 0
                while (c < CC) {
                    if (rowOffset + c * RR <= M) {
                        output.printFormatted(printPrimes.PRIME_NUMBERS[rowOffset + c * RR])
                    }
                    c++
                }
                output.printLineBreak()
                rowOffset++
            }
            output.printPageBreak()
            pageNumber += 1
            pageOffset += RR * CC
        }

        return byteArrayOutputStream.toString(StandardCharsets.UTF_8)
    }
}
