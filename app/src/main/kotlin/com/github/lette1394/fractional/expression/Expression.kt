package com.github.lette1394.fractional.expression

class Expression(private val expression: String) {

    fun asString(): String {
        return toString()
    }

    override fun toString(): String {
        Regex("([0-9]+)/([0-9]+)").findAll(expression).map {  }

        return super.toString()
    }
}
