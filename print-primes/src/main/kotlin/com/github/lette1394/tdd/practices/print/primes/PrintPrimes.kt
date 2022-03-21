package com.github.lette1394.tdd.practices.print.primes

object PrintPrimes {
    fun run() {
        val M = 1000
        val RR = 50
        val CC = 4
        val WW = 10
        val ORDMAX = 30
        val P = IntArray(M + 1)
        var PAGENUMBER: Int
        var PAGEOFFSET: Int
        var ROWOFFSET: Int
        var C: Int
        var J: Int
        var K: Int
        var JPRIME: Boolean
        var ORD: Int
        var SQUARE: Int
        var N: Int
        val MULT = IntArray(ORDMAX + 1)
        J = 1
        K = 1
        P[1] = 2
        ORD = 2
        SQUARE = 9
        while (K < M) {
            do {
                J = J + 2
                if (J == SQUARE) {
                    ORD = ORD + 1
                    SQUARE = P[ORD] * P[ORD]
                    MULT[ORD - 1] = J
                }
                N = 2
                JPRIME = true
                while (N < ORD && JPRIME) {
                    while (MULT[N] < J) MULT[N] = MULT[N] + P[N] + P[N]
                    if (MULT[N] == J) JPRIME = false
                    N = N + 1
                }
            } while (!JPRIME)
            K = K + 1
            P[K] = J
        }
        run {
            PAGENUMBER = 1
            PAGEOFFSET = 1
            while (PAGEOFFSET <= M) {
                println(
                    "The First " + M +
                            " Prime Numbers --- Page " + PAGENUMBER
                )
                println("")
                ROWOFFSET = PAGEOFFSET
                while (ROWOFFSET < PAGEOFFSET + RR) {
                    C = 0
                    while (C < CC) {
                        if (ROWOFFSET + C * RR <= M) System.out.format("%10d", P[ROWOFFSET + C * RR])
                        C++
                    }
                    println("")
                    ROWOFFSET++
                }
                println("\u000c")
                PAGENUMBER = PAGENUMBER + 1
                PAGEOFFSET = PAGEOFFSET + RR * CC
            }
        }
    }
}
