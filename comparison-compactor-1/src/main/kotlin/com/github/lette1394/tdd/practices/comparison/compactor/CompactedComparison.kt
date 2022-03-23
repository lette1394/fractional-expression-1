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
        val front = Front()
        val back = Back()

        val diffExpected = front.cut(back.cut(expected))
        val diffActual = front.cut(back.cut(actual))

        return Result(
            false,
            "expected:<$front[$diffExpected]$back>, but was:<$front[$diffActual]$back>"
        )
    }

    override fun toString(): String = result().description

    private inner class Front {
        fun cut(value: String): String {
            if (common().isBlank()) {
                return value
            }
            return value.substringAfter(common())
        }

        private fun isCompact() = common().isNotBlank() && (contextLength < common().length)

        private fun common() = expected.commonUntilDiff(actual)

        override fun toString(): String {
            if (isCompact()) {
                return "..."
            }
            return common()
        }
    }

    private inner class Back {
        fun cut(value: String): String {
            if (common().isBlank()) {
                return value
            }
            return value.substringBeforeLast(common())
        }

        private fun isCompact() = common().isNotBlank() && (contextLength < common().length)

        private fun common() = expected.reversed().commonUntilDiff(actual.reversed()).reversed()

        override fun toString(): String {
            if (isCompact()) {
                return "..."
            }
            return common()
        }
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
