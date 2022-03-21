package com.github.lette1394.tdd.practices.print.primes

import java.io.PrintStream

class PrintPrimes(
    private val out: PrintStream,
) {
    fun run() {
        val M = 1000
        val RR = 50
        val CC = 4
        val ORDMAX = 30
        val P = IntArray(M + 1)

        var pageNumber: Int
        var pageOffset: Int
        var rowOffset: Int
        var c: Int
        var isJPrime: Boolean
        var square: Int
        var n: Int
        val mult = IntArray(ORDMAX + 1)

        var j = 1
        var k = 1
        P[1] = 2
        var ord = 2
        square = 9
        while (k < M) {
            do {
                j += 2
                if (j == square) {
                    ord += 1
                    square = P[ord] * P[ord]
                    mult[ord - 1] = j
                }
                n = 2
                isJPrime = true
                while (n < ord && isJPrime) {
                    while (mult[n] < j) mult[n] = mult[n] + P[n] + P[n]
                    if (mult[n] == j) isJPrime = false
                    n += 1
                }
            } while (!isJPrime)
            k += 1
            P[k] = j
        }


        run {
            pageNumber = 1
            pageOffset = 1
            while (pageOffset <= M) {
                out.println(
                    "The First " + M +
                            " Prime Numbers --- Page " + pageNumber
                )
                out.println("")
                rowOffset = pageOffset
                while (rowOffset < pageOffset + RR) {
                    c = 0
                    while (c < CC) {
                        if (rowOffset + c * RR <= M) out.format("%10d", P[rowOffset + c * RR])
                        c++
                    }
                    out.println("")
                    rowOffset++
                }
                out.println("\u000c")
                pageNumber += 1
                pageOffset += RR * CC
            }
        }
    }
}
