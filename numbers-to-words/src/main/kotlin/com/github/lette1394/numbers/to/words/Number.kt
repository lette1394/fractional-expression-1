package com.github.lette1394.numbers.to.words

class Number(private val value: Long) {

    fun print(): String {
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
