package com.github.lette1394.password.validator

import arrow.core.Either
import arrow.core.left


class AllPasswordPolicy(private val passwordPolicies: Set<PasswordPolicy>) : PasswordPolicy {
    constructor(vararg passwordPolicies: PasswordPolicy) : this(passwordPolicies.toSet())

    override fun matches(value: String): Either<Reasons, Unit> {
        return passwordPolicies
            .map { it.matches(value) }
            .reduce(::merge)
    }

    private fun merge(acc: Either<Reasons, Unit>, cur: Either<Reasons, Unit>): Either<Reasons, Unit> {
        if (acc.isRight() && cur.isRight()) {
            return cur
        }

        val a = acc.swap().orNull() ?: setOf()
        val b = cur.swap().orNull() ?: setOf()

        return Reasons(a.plus(b)).left()
    }
}
