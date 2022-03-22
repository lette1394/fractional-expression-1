package com.github.lette1394.tdd.practices.comparison.compactor

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CompactedComparisonTest : FreeSpec({
    "b compare c" {
        CompactedComparison(0, "b", "c").toString() shouldBe "expected:<[b]>, but was:<[c]>"
    }

    "ba compare bc" {
        CompactedComparison(1, "ba", "bc").toString() shouldBe "expected:<b[a]>, but was:<b[c]>"
    }

    "ab compare cb" {
        CompactedComparison(1, "ab", "cb").toString() shouldBe "expected:<[a]b>, but was:<[c]b>"
    }
})
