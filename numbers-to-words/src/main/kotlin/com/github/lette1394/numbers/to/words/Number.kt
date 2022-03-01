package com.github.lette1394.numbers.to.words

class Number(private val value: Long) {

    fun print(): String {
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
