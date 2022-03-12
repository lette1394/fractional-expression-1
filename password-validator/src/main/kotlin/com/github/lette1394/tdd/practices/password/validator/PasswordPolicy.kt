package com.github.lette1394.tdd.practices.password.validator

import arrow.core.Either

fun interface PasswordPolicy {
    fun matches(value: String): Either<FailedReasons, Unit>
}
