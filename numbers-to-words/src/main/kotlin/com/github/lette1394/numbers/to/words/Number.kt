package com.github.lette1394.numbers.to.words

class Number(private val value: Long) {
    private val postfixes = listOf("", "십", "백", "천", "만")

    fun print(): String {
        if (value == 0L) {
            return "영"
        }

        return value.toString()
            .toCharArray()
            .map { it.digitToInt() }
            .mapIndexed { index, num -> "${digit(num)}${postfix(index)}" }
            .map { it.replace(Regex("일(.)")) { result -> result.groupValues[1] } }
            .map { it.replace(Regex("영."), "") }
            .map { it.replace(Regex("영"), "") }
            .joinToString("")
    }

    private fun postfix(index: Int): String {
        return postfixes[value.toString().length - index - 1]
    }

    private fun digit(num: Int): String = when (num) {
        0 -> "영"
        1 -> "일"
        2 -> "이"
        3 -> "삼"
        4 -> "사"
        5 -> "오"
        6 -> "육"
        7 -> "칠"
        8 -> "팔"
        9 -> "구"
        else -> TODO()
    }
}
