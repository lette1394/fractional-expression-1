package com.github.lette1394.password.validator

interface Rule {
    fun evaluation(password: String): Evaluation
}
