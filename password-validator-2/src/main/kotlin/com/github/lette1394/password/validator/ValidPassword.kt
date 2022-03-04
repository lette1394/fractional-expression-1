package com.github.lette1394.password.validator

class ValidPassword(private val password: String) {
    fun valid(): Boolean {
        return password.length >= 8
    }

    fun violation(): String {
        if (valid()) {
            return ""
        }
        return "Password must be at least 8 characters"
    }
}
