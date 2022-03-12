package com.github.lette1394.tdd.practices.password.validator

class PasswordMustBeAtLeast8Characters : Rule {
    override fun evaluation(password: String): Evaluation {
        if (password.length >= 8) {
            return Evaluation(true, "")
        }
        return Evaluation(false, "Password must be at least 8 characters")
    }
}
