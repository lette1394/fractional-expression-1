package com.github.lette1394.password.validator

import arrow.core.Either
import arrow.core.Either.Right
import com.github.lette1394.password.validator.Contracts.Companion.requires

class Password private constructor(private val value: String) {
    companion object {
        fun create(value: String): Either<Reasons, Password> {
            return Right(Password("12"))
        }
    }

    init {
        requires({ value.isNotBlank() }, { IllegalArgumentException("") })
    }
}
