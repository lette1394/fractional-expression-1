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
            return List(count) { " ".repeat(targetWidth) }.plus(target).plus(List(count) { " ".repeat(targetWidth) })
                .joinToString(lineSeparator())
        }
        return List(count + 1) { " ".repeat(targetWidth) }.plus(target).plus(List(count) { " ".repeat(targetWidth) })
            .joinToString(lineSeparator())
    }
}
