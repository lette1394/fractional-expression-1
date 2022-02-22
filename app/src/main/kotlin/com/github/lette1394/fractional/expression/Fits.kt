package com.github.lette1394.fractional.expression

import java.lang.System.lineSeparator

object Fits {
    infix fun String.fit(base: String): String {
        return fitHeight(fitWidth(this, base), base)
    }

    private fun String.fitWidth(target: String, base: String): String {
        if (target.width() >= base.width()) {
            return target
        }

        val diff = base.width() - target.width()
        return leftPadding(diff) + target + rightPadding(diff)
    }

    private fun String.fitHeight(target: String, base: String): String {
        if (target.height() >= base.height()) {
            return target
        }

        val diff = base.height() - target.height()
        return listOf(topPadding(diff), target, bottomPadding(diff))
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

    private fun String.linePadding(size: Int = 1) = List(size) { spaces(width()) }.joinToString(lineSeparator())

    private fun spaces(size: Int = 1) = " ".repeat(size)
}
