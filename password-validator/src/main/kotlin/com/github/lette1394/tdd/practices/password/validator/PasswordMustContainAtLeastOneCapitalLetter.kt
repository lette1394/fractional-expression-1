package com.github.lette1394.tdd.practices.password.validator

import arrow.core.Either
import arrow.core.Either.Right
import arrow.core.left
import com.github.lette1394.password.validator.FailedReasons.Companion.reasons
import com.github.lette1394.password.validator.FailedReasons.Reason.PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_CAPITAL_LETTER

class PasswordMustContainAtLeastOneCapitalLetter : PasswordPolicy {
    override fun matches(value: String): Either<FailedReasons, Unit> {
        val hasSingleUppercase = value.any { it.isUpperCase() }
        if (hasSingleUppercase) {
            return Right(Unit)
        }
        return reasons(PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_CAPITAL_LETTER).left()
    }
}
