package com.github.lette1394.tdd.practices.fractional.expression

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class ExpressionTest : FreeSpec({
    "1/2" {
        Expression("1/2").asString() shouldBe """
            | 1 
            |---
            | 2 
        """.trimMargin()
    }

    "1/2 + 1/3" {
        Expression("1/2 + 1/3").asString() shouldBe """
            | 1     1 
            |--- + ---
            | 2     3 
        """.trimMargin()
    }

    "1/2 + 1/3 + 1/4" {
        Expression("1/2 + 1/3 + 1/4").asString() shouldBe """
            | 1     1     1 
            |--- + --- + ---
            | 2     3     4 
        """.trimMargin()
    }

    "1/2 / 1/3" {
        Expression("1/2 / 1/3").asString() shouldBe """
            |  1  
            | --- 
            |  2  
            |-----
            |  1  
            | --- 
            |  3  
        """.trimMargin()
    }

    "1 + (2 - 3)" {
        Expression("1 + (2 - 3)").asString() shouldBe """
            |1 + (2 - 3)
        """.trimMargin()
    }
})
