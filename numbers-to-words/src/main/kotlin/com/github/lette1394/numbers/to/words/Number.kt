package com.github.lette1394.numbers.to.words

class Number(private val value: Long) {

    fun print(): String {
        return when (value) {
            0L -> "영"
            1L -> "일"
            else -> TODO()
        }
    }
}
