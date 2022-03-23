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

    "abc compare adc (0)" {
        CompactedComparison(0, "abc", "adc").result() shouldBe Result(false, "expected:<...[b]...>, but was:<...[d]...>")
    }

    "abc compare adc (1)" {
        CompactedComparison(1, "abc", "adc").result() shouldBe Result(false, "expected:<a[b]c>, but was:<a[d]c>")
    }

    "abcde compare abfde" {
        CompactedComparison(1, "abcde", "abfde").result() shouldBe Result(false, "expected:<...b[c]d...>, but was:<...b[f]d...>")
    }

    "ab compare abc" {
        CompactedComparison(2, "ab", "abc").result() shouldBe Result(false, "expected:<ab[]>, but was:<ab[c]>")
    }

    "bc compare abc (0)" {
        CompactedComparison(0, "bc", "abc").result() shouldBe Result(false, "expected:<[]...>, but was:<[a]...>")
    }

    "bc compare abc (2)" {
        CompactedComparison(2, "bc", "abc").result() shouldBe Result(false, "expected:<[]bc>, but was:<[a]bc>")
    }

    "abc compare abbc (0)" {
        CompactedComparison(0, "abc", "abbc").result() shouldBe Result(false, "expected:<...[]...>, but was:<...[b]...>")
    }

    "abc compare abbc (2)" {
        CompactedComparison(2, "abc", "abbc").result() shouldBe Result(false, "expected:<ab[]c>, but was:<ab[b]c>")
    }
})
