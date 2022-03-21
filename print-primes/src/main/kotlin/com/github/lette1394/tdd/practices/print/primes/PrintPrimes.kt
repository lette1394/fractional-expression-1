package com.github.lette1394.tdd.practices.print.primes

class PrintPrimes(
    private val output: Output,
) {
    val M = 1000
    val PRIME_NUMBERS = IntArray(M + 1)

    fun run() {
        val ORDMAX = 30

        var isJPrime: Boolean
        var square: Int
        var n: Int
        val mult = IntArray(ORDMAX + 1)

        var j = 1
        var k = 1
        PRIME_NUMBERS[1] = 2
        var ord = 2
        square = 9
        while (k < M) {
            do {
                j += 2
                if (j == square) {
                    ord += 1
                    square = PRIME_NUMBERS[ord] * PRIME_NUMBERS[ord]
                    mult[ord - 1] = j
                }
                n = 2
                isJPrime = true
                while (n < ord && isJPrime) {
                    while (mult[n] < j) mult[n] = mult[n] + PRIME_NUMBERS[n] + PRIME_NUMBERS[n]
                    if (mult[n] == j) isJPrime = false
                    n += 1
                }
            } while (!isJPrime)
            k += 1
            PRIME_NUMBERS[k] = j
        }

        output.print(PrimeTextPage(this).asString())
    }
}
