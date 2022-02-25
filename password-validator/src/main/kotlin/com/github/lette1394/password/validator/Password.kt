package com.github.lette1394.password.validator

import arrow.core.Either
import arrow.core.Either.Left
import arrow.core.Either.Right
import com.github.lette1394.password.validator.Contracts.Companion.requiresRun
import com.github.lette1394.password.validator.Reasons.Reason
import com.github.lette1394.password.validator.Reasons.Reason.PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS
import com.github.lette1394.password.validator.Reasons.Reason.PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_CAPITAL_LETTER
import com.github.lette1394.password.validator.Reasons.Reason.THE_PASSWORD_MUST_CONTAIN_AT_LEAST_2_NUMBERS

class Password(private val value: String) {
    companion object {
        fun create(value: String): Either<Reasons, Password> {
            val reasons = mutableSetOf<Reason>()
            requiresRun(function1(value)) { reasons.add(PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS) }
            requiresRun(function2(value)) { reasons.add(THE_PASSWORD_MUST_CONTAIN_AT_LEAST_2_NUMBERS) }
            requiresRun(function3(value)) { reasons.add(PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_CAPITAL_LETTER) }

            if (reasons.isEmpty()) {
                return Right(Password(value))
            }
            return Left(Reasons(reasons))
        }

        private fun function1(value: String): () -> Boolean = { value.length >= 8 }
        private fun function2(value: String): () -> Boolean =
            { value.filter { it.isDigit() }.length >= 2 }

        private fun function3(value: String): () -> Boolean = { value.any { it.isUpperCase() } }
    }

    init {
        requiresRun(function1(value)) { throw IllegalArgumentException(PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS.name) }
        requiresRun(function2(value)) { throw IllegalArgumentException(THE_PASSWORD_MUST_CONTAIN_AT_LEAST_2_NUMBERS.name) }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Password

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return value
    }
}
