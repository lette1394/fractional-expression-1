package com.github.lette1394.fractional.expression

import java.lang.System.lineSeparator

object Fits {
    infix fun String.fit(base: String): String {
        if (this.height() >= base.height()) {
            return this
        }

        val diff = base.height() - this.height()
        return listOf(topPadding(diff), this, bottomPadding(diff))
            .filter { it.isNotEmpty() }
            .joinToString(lineSeparator())
    }

    private fun String.height() = this.split("\n").count()

    private fun String.width() = this.split(lineSeparator()).maxOfOrNull { it.length } ?: this.length

    private fun topPadding(diff: Int) = if (diff % 2 == 0) {
        padding(diff / 2)
    } else {
        padding((diff / 2) + 1)
    }

    private fun bottomPadding(diff: Int) = padding(diff / 2)

    private fun spaces(size: Int = 1) = " ".repeat(size)

    private fun padding(size: Int = 1) = List(size) { spaces(size) }.joinToString(lineSeparator())
}
