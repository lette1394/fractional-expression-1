package com.github.lette1394.fractional.expression

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class ExpressionTest : FreeSpec({
    "1/2 + 1/3" {
        Expression("1/2 + 1/3").asString() shouldBe """
            | 1     1 
            |--- + ---
            | 2     3 
        """.trimMargin()
    }
})
