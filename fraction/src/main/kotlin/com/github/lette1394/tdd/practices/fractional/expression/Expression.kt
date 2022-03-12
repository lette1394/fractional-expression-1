package com.github.lette1394.tdd.practices.fractional.expression

import com.github.lette1394.tdd.practices.fractional.expression.Fits.fitHeight
import com.github.lette1394.tdd.practices.fractional.expression.Fits.fitWidth
import com.github.lette1394.tdd.practices.fractional.expression.Fits.thenDown
import com.github.lette1394.tdd.practices.fractional.expression.Fits.thenRight
import com.github.lette1394.tdd.practices.fractional.expression.Fits.width
import kotlin.math.max

class Expression(private val expression: String) {
    companion object {
        private val fraction = "[0-9]+/[0-9]+"
        private val regex = Regex("([0-9]+/[0-9]+)|[+/]")
        private val regex2 = Regex("(.*) / (.*)")
    }

    fun asString(): String {
        return toString()
    }

    override fun toString(): String {
        val matchEntire = regex2.matchEntire(expression)
        if (matchEntire != null) {
            val numerator = Expression(matchEntire.groupValues[1]).asString()
            val denominator = Expression(matchEntire.groupValues[2]).asString()
            val delimiter = "-".repeat(max(numerator.width(), denominator.width()) + 2)

            return numerator thenDown delimiter thenDown denominator
        }

        return regex.findAll(expression)
            .map {
                if (it.value.trim() == "+") {
                    return@map " + "
                }
                if (it.value.trim() == "/") {
                    return@map "  "
                }

                return@map Fraction(it.value).asString()
            }
            .reduce { acc, s -> acc thenRight s fitHeight acc }
    }
}
