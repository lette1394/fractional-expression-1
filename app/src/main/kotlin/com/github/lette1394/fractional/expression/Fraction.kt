package com.github.lette1394.fractional.expression

import com.github.lette1394.fractional.expression.Fits.thenDown
import kotlin.math.max


class Fraction(private val expression: String) {

    fun asString(): String {
        val numerator = expression.split("/")[0]
        val denominator = expression.split("/")[1]
        val delimiter = "-".repeat(max(numerator.length, denominator.length) + 2)

        return numerator thenDown delimiter thenDown denominator
    }
}
