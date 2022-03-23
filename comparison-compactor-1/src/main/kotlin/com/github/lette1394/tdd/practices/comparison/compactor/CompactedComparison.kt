package com.github.lette1394.tdd.practices.comparison.compactor

class CompactedComparison(
    private val contextLength: Int,
    private val expected: String,
    private val actual: String,
) {
    fun result(): Result {
        if (expected == actual) {
            return sameResult()
        }
        return diffResult()
    }

    private fun sameResult() = Result(true, "the same strings: <$expected>")

    private fun diffResult(): Result {
        var commonFront = commonFront()
        var commonBack = commonBack()

        if (contextLength < commonFront.length && commonFront.isNotBlank()) {
            commonFront = "..."
        }
        if (contextLength < commonBack.length && commonBack.isNotBlank()) {
            commonBack = "..."
        }
        return Result(
            false,
            "expected:<$commonFront[${diff(expected)}]$commonBack>, but was:<$commonFront[${diff(actual)}]$commonBack>"
        )
    }

    private fun diff(value: String): String {
        val commonFront = commonFront()
        val commonBack = commonBack()

        var result = value
        if (commonFront.isNotBlank()) {
            result = result.substringAfter(commonFront)
        }
        if (commonBack.isNotBlank()) {
            result = result.substringBeforeLast(commonBack)
        }
        return result
    }

    private fun commonFront() = expected.commonPart(actual)

    private fun commonBack() = expected.reversed().commonPart(actual.reversed()).reversed()

    private fun String.commonPart(other: String): String {
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
        }.joinToString("")
    }

    override fun toString(): String = result().description
}
