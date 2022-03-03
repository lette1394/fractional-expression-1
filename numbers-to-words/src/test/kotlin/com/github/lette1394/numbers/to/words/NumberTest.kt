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

    "4 digits" {
        forAll(
            row(1000L, "천"),
            row(1001L, "천일"),
            row(1002L, "천이"),
            row(1012L, "천십이"),
            row(1202L, "천이백이"),
            row(1590L, "천오백구십"),
            row(7590L, "칠천오백구십"),
            row(4382L, "사천삼백팔십이"),
            row(9999L, "구천구백구십구"),
        ) { number, word ->
            Number(number).print() shouldBe word
        }
    }

    "5 digits" {
        forAll(
            row(10000L, "만"),
            row(10001L, "만일"),
            row(10002L, "만이"),
            row(10102L, "만백이"),
            row(10102L, "만백이"),
            row(40509L, "사만오백구"),
            row(42599L, "사만이천오백구십구"),
        ) { number, word ->
            Number(number).print() shouldBe word
        }
    }

    "6 digits" {
        forAll(
            row(100000L, "십만"),
            row(100001L, "십만일"),
            row(100002L, "십만이"),
            row(448432L, "사십사만팔천사백삼십이"),
            row(999999L, "구십구만구천구백구십구"),
            row(999990L, "구십구만구천구백구십"),
            row(999909L, "구십구만구천구백구"),
            row(999099L, "구십구만구천구십구"),
            row(990999L, "구십구만구백구십구"),
            row(909999L, "구십만구천구백구십구"),
            row(900999L, "구십만구백구십구"),
            row(990099L, "구십구만구십구"),
            row(990009L, "구십구만구"),
        ) { number, word ->
            Number(number).print() shouldBe word
        }
    }

    "7 digits" {
        forAll(
            row(8100000L, "팔백십만"),
            row(8100001L, "팔백십만일"),
            row(8100002L, "팔백십만이"),
            row(8448432L, "팔백사십사만팔천사백삼십이"),
            row(8999999L, "팔백구십구만구천구백구십구"),
            row(8999990L, "팔백구십구만구천구백구십"),
            row(8999909L, "팔백구십구만구천구백구"),
            row(8999099L, "팔백구십구만구천구십구"),
            row(8990999L, "팔백구십구만구백구십구"),
            row(8909999L, "팔백구십만구천구백구십구"),
            row(8089999L, "팔백팔만구천구백구십구"),
            row(8900999L, "팔백구십만구백구십구"),
            row(8990099L, "팔백구십구만구십구"),
            row(8990009L, "팔백구십구만구"),
        ) { number, word ->
            Number(number).print() shouldBe word
        }
    }

    "9 digits" {
        forAll(
            row(100000000L, "억"),
            row(123456789L, "억이천삼백사십오만육천칠백팔십구"),
        ) { number, word ->
            Number(number).print() shouldBe word
        }
    }
})
