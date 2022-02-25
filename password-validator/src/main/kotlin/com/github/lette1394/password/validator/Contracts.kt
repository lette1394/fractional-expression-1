package com.github.lette1394.password.validator

class Contracts {
    companion object {
        fun requires(condition: () -> Boolean, exception: () -> Exception) {
            if (condition()) {
                return
            }
            throw exception()
        }
    }
}
