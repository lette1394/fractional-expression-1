package com.github.lette1394.tdd.practices.comparison.compactor

class CompactedComparison(
    private val contextLength: Int,
    private val expected: String,
    private val actual: String,
) {

    override fun toString(): String {
        return "expected:<[$expected]>, but was:<[$actual]>"
    }
}
