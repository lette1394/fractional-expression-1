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
        return List(diff) { " ".repeat(targetWidth) }.plus(target).joinToString(lineSeparator())
    }
}
