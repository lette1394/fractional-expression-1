package com.github.lette1394.password.validator

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.github.lette1394.password.validator.FailedReasons.Companion.reasons
import com.github.lette1394.password.validator.FailedReasons.Reason.PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_SPECIAL_CHARACTER

class PasswordMustContainAtLeastOneSpecialCharacter() : PasswordPolicy {
    private val regex = Regex("[!@#$%^&*()\\-+]")

    override fun matches(value: String): Either<FailedReasons, Unit> {
        if (value.contains(regex)) {
            return Unit.right()
        }
        return reasons(PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_SPECIAL_CHARACTER).left()
    }
}
