package com.github.lette1394.password.validator

class PasswordMustContainAtLeast2Numbers : Rule {
    override fun evaluation(password: String): Evaluation {
        val numberCount = password.filter { it.isDigit() }.length
        if (numberCount >= 2) {
            return Evaluation(true, "")
        }
        return Evaluation(false, "The password must contain at least 2 numbers")
    }
}
