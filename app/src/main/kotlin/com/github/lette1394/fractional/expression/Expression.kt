package com.github.lette1394.fractional.expression

import com.github.lette1394.fractional.expression.Fits.fitHeight
import com.github.lette1394.fractional.expression.Fits.thenRight

class Expression(private val expression: String) {
    private val regex = Regex("([0-9]+/[0-9]+)|\\+")

    fun asString(): String {
        return toString()
    }

    override fun toString(): String {
        return regex.findAll(expression)
            .map {
                if (it.value.trim() == "+") {
                    return@map " + "
                }
                return@map Fraction(it.value).asString()
            }
            .reduce { acc, s -> acc thenRight s fitHeight acc }
    }
}
