package com.github.lette1394.fractional.expression

import com.github.lette1394.fractional.expression.Fits.thenDown


class Fraction(private val expression: String) {

    fun asString(): String {

        val delimiter = "---"
        val numerator = expression.split("/")[0]
        val denominator = expression.split("/")[1]

        return numerator thenDown delimiter thenDown denominator
    }
}
