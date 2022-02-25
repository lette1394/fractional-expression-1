package com.github.lette1394.password.validator

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.FreeSpec

class PasswordTest : FreeSpec({
    "Password must be at least 8 characters - 1" {
        shouldNotThrowAny {
            Password("12345678")
        }
    }

    "Password must be at least 8 characters - 2" {
        shouldThrowAny {
            Password("1234567")
        }
    }

    "Password must be at least 8 characters - 3" {
        shouldThrowAny {
            Password("")
        }
    }
})
