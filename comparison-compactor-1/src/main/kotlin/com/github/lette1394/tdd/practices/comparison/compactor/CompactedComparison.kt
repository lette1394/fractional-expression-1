package com.github.lette1394.tdd.practices.comparison.compactor

class CompactedComparison(
    private val contextLength: Int,
    private val expected: String,
    private val actual: String,
) {

    override fun toString(): String {
        val common = common()
        return "expected:<$common[${expected()}]>, but was:<$common[${actual()}]>"
    }

    private fun expected() = expected.substringAfter(common())

    private fun actual() = actual.substringAfter(common())

    private fun common(): String {
        fun filter() = { a: Char, b: Char ->
            if (a == b) {
                "" + a
            } else {
                ""
            }
        }
        return expected.zip(actual, filter()).joinToString("")
    }
}
