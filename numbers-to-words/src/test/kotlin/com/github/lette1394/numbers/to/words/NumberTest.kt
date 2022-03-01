package com.github.lette1394.numbers.to.words

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class NumberTest : FreeSpec({
    "0" {
        Number(0).print() shouldBe "영"
    }

    "1" {
        Number(1).print() shouldBe "일"
    }
})
