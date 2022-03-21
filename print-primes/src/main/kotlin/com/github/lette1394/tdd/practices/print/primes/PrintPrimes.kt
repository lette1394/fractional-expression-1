package com.github.lette1394.tdd.practices.print.primes

class PrintPrimes(
    val count: Int,
    private val output: Output,
) {
    val PRIME_NUMBERS = IntArray(count + 1)

    fun run() {
        output.print(PrimeTextPage(primes(), 50, 4).asString())
    }

    private fun primes(): ArrayList<Int> {
        val ORDMAX = 30

        val mult = IntArray(ORDMAX + 1)

        var nextPrime = 1
        var primeIndex = 1
        val primes = ArrayList<Int>()

        PRIME_NUMBERS[1] = 2
        primes.add(2)

        var ord = 2
        var square = 9

        while (primeIndex < count) {
            do {
                nextPrime += 2
                if (nextPrime == square) {
                    ord += 1
                    square = PRIME_NUMBERS[ord] * PRIME_NUMBERS[ord]
                    mult[ord - 1] = nextPrime
                }

                var n = 2
                var foundNextPrime = true
                while (n < ord && foundNextPrime) {
                    while (mult[n] < nextPrime) {
                        mult[n] = mult[n] + PRIME_NUMBERS[n] + PRIME_NUMBERS[n]
                    }
                    if (mult[n] == nextPrime) {
                        foundNextPrime = false
                    }
                    n += 1
                }
            } while (!foundNextPrime)

            primeIndex += 1

            PRIME_NUMBERS[primeIndex] = nextPrime
            primes.add(nextPrime)
        }

        return primes
    }
}
