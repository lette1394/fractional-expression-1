package com.github.lette1394.tdd.practices.comparison.compactor

class CompactedComparison(
    private val contextLength: Int,
    private val expected: String,
    private val actual: String,
) {

    override fun toString(): String {
        val commonFront = expected.commonFront(actual)
        val commonBack = expected.commonBack(actual)
        return "expected:<$commonFront[${diffExpected()}]$commonBack>, but was:<$commonFront[${diffActual()}]$commonBack>"
    }

    private fun diffExpected(): String {
        val commonFront = expected.commonFront(actual)
        val commonBack = expected.commonBack(actual)

        var result = expected
        if (commonFront.isNotBlank()) {
            result = result.substringAfter(commonFront)
        }
        if (commonBack.isNotBlank()) {
            result = result.substringBeforeLast(commonBack)
        }
        return result
    }

    private fun diffActual(): String {
        val commonFront = expected.commonFront(actual)
        val commonBack = expected.commonBack(actual)

        var result = actual
        if (commonFront.isNotBlank()) {
            result = result.substringAfter(commonFront)
        }
        if (commonBack.isNotBlank()) {
            result = result.substringBeforeLast(commonBack)
        }
        return result
    }

    private fun String.commonFront(other: String): String {
        var done = false
        return zip(other) { a: Char, b: Char ->
            if (done) {
                return@zip ""
            }
            if (a == b) {
                "" + a
            } else {
                done = true
                ""
            }
        }.joinToString("").trim()
    }

    private fun String.commonBack(other: String): String {
        return reversed().commonFront(other.reversed()).reversed()
    }
}
