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

    "2 digits" {
        forAll(
            row(10L, "십"),
            row(11L, "십일"),
            row(12L, "십이"),
            row(23L, "이십삼"),
            row(34L, "삼십사"),
            row(44L, "사십사"),
            row(76L, "칠십육"),
            row(47L, "사십칠"),
            row(88L, "팔십팔"),
            row(99L, "구십구"),
        ) { number, word ->
            Number(number).print() shouldBe word
        }
    }

    "3 digits" {
        forAll(
            row(100L, "백"),
            row(101L, "백일"),
            row(102L, "백이"),
            row(110L, "백십"),
            row(111L, "백십일"),
            row(159L, "백오십구"),
            row(200L, "이백"),
            row(201L, "이백일"),
            row(241L, "이백사십일"),
            row(248L, "이백사십팔"),
            row(999L, "구백구십구"),
        ) { number, word ->
            Number(number).print() shouldBe word
        }
    }
})
