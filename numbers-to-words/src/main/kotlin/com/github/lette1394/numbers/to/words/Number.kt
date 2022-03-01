package com.github.lette1394.numbers.to.words

class Number(private val value: Long) {

    fun print(): String {
        if (value.toString().length >= 3) {
            val one = value / 100
            val two = (value / 10) % 10
            val three = value % 10

            val one_ = when (one) {
                0L -> ""
                1L -> ""
                2L -> "이"
                3L -> "삼"
                4L -> "사"
                5L -> "오"
                6L -> "육"
                7L -> "칠"
                8L -> "팔"
                9L -> "구"
                else -> TODO()
            } + "백"

            val two_ = when (two) {
                0L -> ""
                1L -> "십"
                2L -> "이십"
                3L -> "삼십"
                4L -> "사십"
                5L -> "오십"
                6L -> "육십"
                7L -> "칠십"
                8L -> "팔십"
                9L -> "구십"
                else -> TODO()
            }

            val three_ = when (three) {
                0L -> ""
                1L -> "일"
                2L -> "이"
                3L -> "삼"
                4L -> "사"
                5L -> "오"
                6L -> "육"
                7L -> "칠"
                8L -> "팔"
                9L -> "구"
                else -> TODO()
            }

            return "$one_$two_$three_"
        }


        if (value.toString().length >= 2) {
            val up = value / 10
            val down = value % 10

            val first = when (up) {
                0L -> ""
                1L -> ""
                2L -> "이"
                3L -> "삼"
                4L -> "사"
                5L -> "오"
                6L -> "육"
                7L -> "칠"
                8L -> "팔"
                9L -> "구"
                else -> TODO()
            } + "십"

            val second = when (down) {
                0L -> ""
                1L -> "일"
                2L -> "이"
                3L -> "삼"
                4L -> "사"
                5L -> "오"
                6L -> "육"
                7L -> "칠"
                8L -> "팔"
                9L -> "구"
                else -> TODO()
            }

            return first + second
        }

        return when (value) {
            0L -> "영"
            1L -> "일"
            2L -> "이"
            3L -> "삼"
            4L -> "사"
            5L -> "오"
            6L -> "육"
            7L -> "칠"
            8L -> "팔"
            9L -> "구"
            else -> TODO()
        }
    }
}
