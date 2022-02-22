package com.github.lette1394.fractional.expression

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class FractionTest : FreeSpec({

    "1/2" {
        Fraction("1/2").asString() shouldBe """
            | 1 
            |---
            | 2 
        """.trimMargin()
    }

    "11/23" {
        Fraction("11/23").asString() shouldBe """
            | 11 
            |----
            | 23 
        """.trimMargin()
    }

    "11/235" {
        Fraction("11/235").asString() shouldBe """
            |  11 
            |-----
            | 235 
        """.trimMargin()
    }
})
