package com.github.lette1394.fractional.expression

import java.lang.System.lineSeparator

object Fits {
    infix fun String.fit(base: String): String {
        return fitWidth(base).fitHeight(base)
    }

    infix fun String.fitWidth(base: String): String {
        if (this.width() >= base.width()) {
            return this
        }

        val diff = base.width() - this.width()
        return this.split(lineSeparator())
            .map { leftPadding(diff) + it + rightPadding(diff) }
            .joinToString(lineSeparator())
    }

    infix fun String.fitHeight(base: String): String {
        if (this.height() >= base.height()) {
            return this
        }

        val diff = base.height() - this.height()
        return listOf(topPadding(diff), this, bottomPadding(diff))
            .filter { it.isNotEmpty() }
            .joinToString(lineSeparator())
    }

    infix fun String.thenDown(down: String): String {
        val fitThis = this.fitWidth(down)
        val fitDown = down.fitWidth(this)

        return listOf(fitThis, fitDown)
            .filter { it.isNotEmpty() }
            .joinToString(lineSeparator())
    }

    private fun String.height() = this.split("\n").count()

    private fun String.width() = this.split(lineSeparator()).maxOfOrNull { it.length } ?: this.length

    private fun String.topPadding(diff: Int) = if (diff % 2 == 0) {
        linePadding(diff / 2)
    } else {
        linePadding((diff / 2) + 1)
    }

    private fun String.bottomPadding(diff: Int) = linePadding(diff / 2)

    private fun String.leftPadding(diff: Int) = if (diff % 2 == 0) {
        spaces(diff / 2)
    } else {
        spaces((diff / 2) + 1)
    }

    private fun String.rightPadding(diff: Int) = spaces(diff / 2)

    private fun String.linePadding(height: Int) = List(height) { spaces(width()) }.joinToString(lineSeparator())

    private fun spaces(size: Int = 1) = " ".repeat(size)
}
