package com.github.lette1394.fractional.expression

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class FractionTest : FreeSpec({

    "wow" {
        Fraction("1 + 1/2").asString() shouldBe """
            |     1 
            |1 + ---
            |     2 
        """.trimMargin()
    }
})
