package com.github.lette1394.tdd.practices.password.validator

interface Rule {
    fun evaluation(password: String): Evaluation
}
