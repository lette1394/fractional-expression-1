package com.github.lette1394.password.validator

import arrow.core.Either
import arrow.core.Either.Left
import arrow.core.Either.Right
import com.github.lette1394.password.validator.Contracts.Companion.requiresRun
import com.github.lette1394.password.validator.Reasons.Reason
import com.github.lette1394.password.validator.Reasons.Reason.PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS

class Password(private val value: String) {
    companion object {
        fun create(value: String): Either<Reasons, Password> {
            val reasons = mutableSetOf<Reason>()
            requiresRun(function(value)) { reasons.add(PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS) }

            if (reasons.isEmpty()) {
                return Right(Password(value))
            }
            return Left(Reasons(reasons))
        }

        private fun function(value: String): () -> Boolean = { value.length >= 8 }
    }

    init {
        requiresRun(function(value)) { throw IllegalArgumentException("") }
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
}
