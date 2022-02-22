package com.github.lette1394.fractional.expression

import java.lang.System.lineSeparator

object Fits {
    infix fun String.fit(base: String): String {
        val targetHeight = this.split("\n").count()
        val baseHeight = base.split("\n").count()
        val targetWidth = this.split(lineSeparator()).maxOfOrNull { it.length } ?: this.length

        if (targetHeight >= baseHeight) {
            return this
        }

        val diff = baseHeight - targetHeight
        val count = diff / 2
        if (diff % 2 == 0) {
            return listOf(height(count), this, height(count)).filter { it.isNotEmpty() }.joinToString(lineSeparator())
        }
        return listOf(height(count + 1), this, height(count)).filter { it.isNotEmpty() }.joinToString(lineSeparator())
    }

    private fun spaces(size: Int = 1) = " ".repeat(size)

    private fun height(size: Int = 1) = List(size) { spaces(size) }.joinToString(lineSeparator())
}
