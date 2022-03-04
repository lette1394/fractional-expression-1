package com.github.lette1394.password.validator

class ValidPassword(private val rule: Rule, private val password: String) {
    fun valid(): Boolean {
        return evaluation().valid
    }

    fun violation(): String {
        return evaluation().violation
    }

    fun stringValue(): String {
        if (valid()) {
            return password
        }
        throw IllegalStateException(violation())
    }

    private fun evaluation() = rule.evaluation(password)
}
