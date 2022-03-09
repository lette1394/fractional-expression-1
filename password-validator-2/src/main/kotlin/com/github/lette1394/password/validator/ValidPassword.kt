package com.github.lette1394.password.validator

class ValidPassword(private val rule: Rule, private val password: String) {
    // 도메인에서 invalid password 를 원하는 경우가 있는가?
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
