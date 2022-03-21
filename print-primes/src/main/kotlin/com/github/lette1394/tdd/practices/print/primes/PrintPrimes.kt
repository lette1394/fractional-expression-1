package com.github.lette1394.tdd.practices.print.primes

class PrintPrimes(
    val count: Int,
    private val output: Output,
) {
    val PRIME_NUMBERS = IntArray(count + 1)

    fun run() {
        val ORDMAX = 30

        var isJPrime: Boolean
        var square: Int
        var n: Int
        val mult = IntArray(ORDMAX + 1)

        var nextPrime = 1
        var primeIndex = 1
        val primes = ArrayList<Int>()

        PRIME_NUMBERS[1] = 2
        primes.add(2)

        var ord = 2
        square = 9

        while (primeIndex < count) {
            do {
                nextPrime += 2
                if (nextPrime == square) {
                    ord += 1
                    square = PRIME_NUMBERS[ord] * PRIME_NUMBERS[ord]
                    mult[ord - 1] = nextPrime
                }
                n = 2
                isJPrime = true
                while (n < ord && isJPrime) {
                    while (mult[n] < nextPrime) {
                        mult[n] = mult[n] + PRIME_NUMBERS[n] + PRIME_NUMBERS[n]
                    }
                    if (mult[n] == nextPrime) {
                        isJPrime = false
                    }
                    n += 1
                }
            } while (!isJPrime)
            primeIndex += 1

            PRIME_NUMBERS[primeIndex] = nextPrime
            primes.add(nextPrime)
        }

        output.print(PrimeTextPage(primes, 50, 4).asString())
    }
}
