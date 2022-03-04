package com.github.lette1394.numbers.to.words

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class Number2Test : FreeSpec({
    "만 이하" {
        forAll(
            row(0L, "영"),
            row(6L, "육"),
            row(10L, "일십"),
            row(11L, "일십일"),
            row(80L, "팔십"),
            row(84L, "팔십사"),
            row(130L, "일백삼십"),
            row(234L, "이백삼십사"),
            row(300L, "삼백"),
            row(304L, "삼백사"),
            row(2519L, "이천오백십구"),
            row(2509L, "이천오백구"),
            row(6600L, "육천육백"),
            row(6004L, "육천사"),
            row(6104L, "육천일백사"),
            row(7065L, "칠천육십오"),
            row(8888L, "팔천팔백팔십팔"),
        ) { value, word ->
            Number2(value).print() shouldBe word
        }
    }
})
