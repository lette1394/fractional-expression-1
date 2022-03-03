package com.github.lette1394.numbers.to.words

class Number(private val value: Long) {
    private val postfixes = listOf("", "십", "백", "천")
    private val postfixes2 = listOf("", "*만*", "*억*")

    fun print(): String {
        if (value == 0L) {
            return "영"
        }

        return value.toString()
            .toCharArray()
            .map { it.digitToInt() }
            .mapIndexed { index, num -> "${digit(num)}${postfix1(index)}${postfix2(index)}" }
            .map { it.replace(Regex("일(.)")) { result -> result.groupValues[1] } }
            .map { it.replace(Regex("영([가-핳])"), "") }
            .map { it.replace(Regex("영"), "") }
            .map { it.replace(Regex("\\*"), "") }
            .joinToString("")
    }

    private fun postfix1(index: Int): String {
        val position = (value.toString().length - index - 1)
        return postfixes[position % 4]
    }

    private fun postfix2(index: Int): String {
        val position = (value.toString().length - index - 1)
        return if (position == 4) {
            postfixes2[1]
        } else {
            ""
        }
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
