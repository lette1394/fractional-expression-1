package com.github.lette1394.tdd.practices.password.validator

import arrow.core.Either
import arrow.core.left


class AllPasswordPolicy(private val passwordPolicies: Set<PasswordPolicy>) : PasswordPolicy {
    constructor(vararg passwordPolicies: PasswordPolicy) : this(passwordPolicies.toSet())

    override fun matches(value: String): Either<FailedReasons, Unit> {
        return passwordPolicies
            .map { it.matches(value) }
            .reduce(::merge)
    }

    private fun merge(acc: Either<FailedReasons, Unit>, cur: Either<FailedReasons, Unit>): Either<FailedReasons, Unit> {
        if (acc.isRight() && cur.isRight()) {
            return cur
        }

        val a = acc.swap().orNull() ?: setOf()
        val b = cur.swap().orNull() ?: setOf()

        return FailedReasons(a.plus(b)).left()
    }
}
