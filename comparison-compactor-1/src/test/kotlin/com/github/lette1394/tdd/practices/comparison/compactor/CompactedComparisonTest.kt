package com.github.lette1394.tdd.practices.comparison.compactor

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CompactedComparisonTest : FreeSpec({
    "test message" {
        CompactedComparison(0, "b", "c").toString() shouldBe "expected:<[b]>, but was:<[c]>"
    }
})
