package com.github.lette1394.fractional.expression

import java.lang.System.lineSeparator

object Fits {
    fun width(target: String, base: String): String {
        val targetHeight = target.split("\n").count()
        val baseHeight = base.split("\n").count()
        val targetWidth = target.split(lineSeparator()).maxOfOrNull { it.length } ?: target.length

        if (targetHeight >= baseHeight) {
            return target
        }

        val diff = baseHeight - targetHeight
        val count = diff / 2
        if (diff % 2 == 0) {
            return listOf(height(count), target, height(count)).filter { it.isNotEmpty() }.joinToString(lineSeparator())
        }
        return listOf(height(count + 1), target, height(count)).filter { it.isNotEmpty() }.joinToString(lineSeparator())
    }

    private fun spaces(size: Int = 1) = " ".repeat(size)

    private fun height(size: Int = 1) = List(size) { spaces(size) }.joinToString(lineSeparator())
}
