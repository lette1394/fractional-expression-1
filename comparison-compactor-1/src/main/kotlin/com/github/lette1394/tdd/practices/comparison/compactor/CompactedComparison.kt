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
        val front = Front(expected, actual)
        val back = Back(front.expected(), front.actual())
        val diff = Diff(back.expected(), back.actual())

        return Result(
            false,
            "expected:<$front[${diff.expected}]$back>, but was:<$front[${diff.actual}]$back>"
        )
    }

    override fun toString(): String = result().description

    private inner class Front(private val expected: String, private val actual: String) {

        fun expected() = cut(expected)

        fun actual() = cut(actual)

        override fun toString(): String {
            val common = common()
            if (isCompact()) {
                with(common) {
                    return "...${substring(length - contextLength, length)}"
                }
            }
            return common
        }

        private fun cut(value: String): String {
            if (common().isBlank()) {
                return value
            }
            return value.substringAfter(common())
        }

        private fun isCompact() = common().isNotBlank() && (contextLength < common().length)

        private fun common() = expected.commonUntilDiff(actual)
    }

    private inner class Back(private val expected: String, private val actual: String) {
        fun expected() = cut(expected)

        fun actual() = cut(actual)

        override fun toString(): String {
            val common = common()
            if (isCompact()) {
                with(common) {
                    return "${substring(0, contextLength)}..."
                }
            }
            return common()
        }

        private fun cut(value: String): String {
            if (common().isBlank()) {
                return value
            }
            return value.substringBeforeLast(common())
        }

        private fun isCompact() = common().isNotBlank() && (contextLength < common().length)

        private fun common() = expected.reversed().commonUntilDiff(actual.reversed()).reversed()
    }

    private inner class Diff(val expected: String, val actual: String) {
    }

    private fun String.commonUntilDiff(other: String): String {
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
}
