package com.github.lette1394.password.validator

import arrow.core.Either
import arrow.core.Either.Right
import arrow.core.left
import com.github.lette1394.password.validator.Reasons.Companion.reasons
import com.github.lette1394.password.validator.Reasons.Reason.PASSWORD_MUST_CONTAIN_AT_LEAST_2_NUMBERS

class PasswordMustContainAtLeast2Numbers : PasswordPolicy {
    override fun matches(value: String): Either<Reasons, Unit> {
        val numberCount = value.filter { it.isDigit() }.length
        if (numberCount >= 2) {
            return Right(Unit)
        }
        return reasons(PASSWORD_MUST_CONTAIN_AT_LEAST_2_NUMBERS).left()
    }
}
