package com.github.lette1394.password.validator

import com.github.lette1394.password.validator.Reasons.Reason

class Reasons(private val reasons: Set<Reason>): Set<Reason> by reasons {
    companion object {
        fun reasons(vararg reasons: Reason) = Reasons(reasons.toSet())
    }

    enum class Reason {
        PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Reasons

        if (reasons != other.reasons) return false

        return true
    }

    override fun hashCode(): Int {
        return reasons.hashCode()
    }
}
