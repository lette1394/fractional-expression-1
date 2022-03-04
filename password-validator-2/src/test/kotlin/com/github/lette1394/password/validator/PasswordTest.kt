package com.github.lette1394.password.validator

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class PasswordTest : FreeSpec({
    "Password must be at least 8 characters: true" {
        ValidPassword("12345678").valid() shouldBe true
        ValidPassword("123456789").valid() shouldBe true
        ValidPassword("123456789abcd").valid() shouldBe true
    }

    "Password must be at least 8 characters: false" {
        ValidPassword("").valid() shouldBe false
        ValidPassword("").violation() shouldBe "Password must be at least 8 characters"

        ValidPassword("1234567").valid() shouldBe false
        ValidPassword("1234567").violation() shouldBe "Password must be at least 8 characters"
    }
})
