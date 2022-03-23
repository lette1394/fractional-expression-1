package com.github.lette1394.tdd.practices.comparison.compactor

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CompactedComparisonTest : FreeSpec({
    "ab compare ab" {
        CompactedComparison(1, "ab", "ab").result() shouldBe Result(true, "the same strings: <ab>")
    }

    "b compare c" {
        CompactedComparison(0, "b", "c").result() shouldBe Result(false, "expected:<[b]>, but was:<[c]>")
    }

    "ba compare bc" {
        CompactedComparison(1, "ba", "bc").result() shouldBe Result(false, "expected:<b[a]>, but was:<b[c]>")
    }

    "ab compare cb" {
        CompactedComparison(1, "ab", "cb").result() shouldBe Result(false, "expected:<[a]b>, but was:<[c]b>")
    }
})
