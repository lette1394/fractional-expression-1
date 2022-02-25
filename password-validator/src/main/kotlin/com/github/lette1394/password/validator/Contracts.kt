package com.github.lette1394.password.validator

class Contracts {
    companion object {
        fun requiresThrows(condition: () -> Boolean, exception: () -> Exception) =
            requiresRun(condition) { throw exception() }

        fun requiresRun(condition: () -> Boolean, ifViolatedThen: () -> Unit) {
            if (condition()) {
                return
            }
            ifViolatedThen()
        }
    }
}
