package com.github.lette1394.password.validator

import arrow.core.Either
import arrow.core.Either.Right
import arrow.core.left
import com.github.lette1394.password.validator.FailedReasons.Companion.reasons
import com.github.lette1394.password.validator.FailedReasons.Reason.PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS

class PasswordMustBeAtLeast8Characters : PasswordPolicy {
    override fun matches(value: String): Either<FailedReasons, Unit> {
        if (value.length >= 8) {
            return Right(Unit)
        }
        return reasons(PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS).left()
    }
}
