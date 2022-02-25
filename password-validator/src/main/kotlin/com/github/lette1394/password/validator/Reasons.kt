package com.github.lette1394.password.validator

import com.github.lette1394.password.validator.Reasons.Reason

class Reasons(private val reasons: Set<Reason>): Set<Reason> by reasons {
    companion object {
        fun reasons(vararg reasons: Reason) = Reasons(reasons.toSet())
    }

    enum class Reason {
        PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS
    }
}
