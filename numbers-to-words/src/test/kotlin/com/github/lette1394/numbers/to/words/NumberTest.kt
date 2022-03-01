package com.github.lette1394.numbers.to.words

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class NumberTest : FreeSpec({
    "1 digit" {
        forAll(
            row(0L, "영"),
            row(1L, "일"),
            row(2L, "이"),
            row(3L, "삼"),
            row(4L, "사"),
            row(5L, "오"),
            row(6L, "육"),
            row(7L, "칠"),
            row(8L, "팔"),
            row(9L, "구"),
        ) { number, word ->
            Number(number).print() shouldBe word
        }
    }
})
