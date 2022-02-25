package com.github.lette1394.password.validator

import arrow.core.Either

class Password private constructor(private val value: String) {
    companion object {
        val policy = AllPasswordPolicy(
            PasswordMustBeAtLeast8Characters(),
            PasswordMustContainAtLeast2Numbers(),
            PasswordMustContainAtLeastOneCapitalLetter(),
        )

        fun create(value: String): Either<Reasons, Password> {
            return policy.matches(value).map { Password(value) }
        }
    }

    fun asString() = toString()

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

    class Factory(private val passwordPolicy: PasswordPolicy) {
        fun create(value: String) = passwordPolicy.matches(value).map { Password(value) }
    }
}
