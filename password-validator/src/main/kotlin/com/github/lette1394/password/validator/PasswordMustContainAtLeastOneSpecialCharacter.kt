package com.github.lette1394.password.validator

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.github.lette1394.password.validator.Reasons.Companion.reasons
import com.github.lette1394.password.validator.Reasons.Reason.PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_SPECIAL_CHARACTER

class PasswordMustContainAtLeastOneSpecialCharacter(
    private val hasSpecialCharacters: (value: String) -> Boolean
) : PasswordPolicy {

    override fun matches(value: String): Either<Reasons, Unit> {
        if (hasSpecialCharacters(value)) {
            return Unit.right()
        }
        return reasons(PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_SPECIAL_CHARACTER).left()
    }
}
