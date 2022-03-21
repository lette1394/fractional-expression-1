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
        return Pages().asString()
    }

    inner class Pages {
        private val byteArrayOutputStream = ByteArrayOutputStream()
        private val output = Output(PrintStream(byteArrayOutputStream))

        private var pageNumber = 1
        private var pageOffset = 1

        fun asString(): String {
            while (allRendered()) {
                printHeader()
                printPrimes()

                next()
            }

            return printAsString()
        }

        private fun allRendered() = pageOffset <= primes.size

        private fun printHeader() {
            output.println("The First ${primes.size} Prime Numbers --- Page $pageNumber")
            output.printLineBreak()
        }

        private fun printPrimes() {
            var rowOffset = pageOffset
            while (rowOffset < pageOffset + rowSize) {
                printRow(rowOffset)
                rowOffset++
            }
            output.printPageBreak()
        }

        private fun printRow(rowOffset: Int) {
            var columnIndex = 0
            while (columnIndex < columnSize) {
                printColumn(rowOffset, columnIndex)
                columnIndex++
            }
            output.printLineBreak()
        }

        private fun printColumn(rowOffset: Int, columnIndex: Int) {
            if (rowOffset + columnIndex * rowSize <= primes.size) {
                output.printPrime(primes[rowOffset + columnIndex * rowSize - 1])
            }
        }

        private fun next() {
            pageNumber += 1
            pageOffset += rowSize * columnSize
        }

        private fun printAsString() = byteArrayOutputStream.toString(StandardCharsets.UTF_8)
    }
}
