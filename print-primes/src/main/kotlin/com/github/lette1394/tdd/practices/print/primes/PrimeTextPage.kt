package com.github.lette1394.tdd.practices.print.primes

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.StandardCharsets

class PrimeTextPage(
    private val primes: List<Int>,
    private val rowSize: Int,
    private val columnSize: Int
) {

    fun asString(): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val output = Output(PrintStream(byteArrayOutputStream))

        var pageNumber = 1
        var pageOffset = 1

        while (pageOffset <= primes.size) {
            output.println("The First ${primes.size} Prime Numbers --- Page $pageNumber")
            output.printLineBreak()

            var rowOffset = pageOffset
            while (rowOffset < pageOffset + rowSize) {
                var columnIndex = 0
                while (columnIndex < columnSize) {
                    if (rowOffset + columnIndex * rowSize <= primes.size) {
                        output.printFormatted(primes[rowOffset + columnIndex * rowSize - 1])
                    }
                    columnIndex++
                }
                output.printLineBreak()
                rowOffset++
            }
            output.printPageBreak()
            pageNumber += 1
            pageOffset += rowSize * columnSize
        }

        return byteArrayOutputStream.toString(StandardCharsets.UTF_8)
    }
}
