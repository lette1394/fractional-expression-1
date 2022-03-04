package com.github.lette1394.password.validator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class ValidPasswordTest : FreeSpec({
    "Password must be at least 8 characters" - {
        "input: 1234578" {
            ValidPassword("12345678").valid() shouldBe true
            ValidPassword("12345678").violation() shouldBe ""
            ValidPassword("12345678").stringValue() shouldBe "12345678"
        }

        "input: 123456789" {
            ValidPassword("123456789").valid() shouldBe true
            ValidPassword("123456789").violation() shouldBe ""
            ValidPassword("123456789").stringValue() shouldBe "123456789"
        }

        "input: 123456789abcd" {
            ValidPassword("123456789abcd").valid() shouldBe true
            ValidPassword("123456789abcd").violation() shouldBe ""
            ValidPassword("123456789abcd").stringValue() shouldBe "123456789abcd"
        }

        "input: (empty)" {
            ValidPassword("").valid() shouldBe false
            ValidPassword("").violation() shouldBe "Password must be at least 8 characters"
            shouldThrow<IllegalStateException> { ValidPassword("").stringValue() }
        }

        "input: 1234567" {
            ValidPassword("1234567").valid() shouldBe false
            ValidPassword("1234567").violation() shouldBe "Password must be at least 8 characters"
            shouldThrow<IllegalStateException> { ValidPassword("1234567").stringValue() }
        }
    }

    "The password must contain at least 2 numbers" - {
        "input: 12" {
            ValidPassword("12").valid() shouldBe true
            ValidPassword("12").violation() shouldBe ""
            ValidPassword("12").stringValue() shouldBe "12"
        }

        "input: abc" {
            ValidPassword("abc").valid() shouldBe false
            ValidPassword("abc").violation() shouldBe "The password must contain at least 2 numbers"
            shouldThrow<IllegalStateException> { ValidPassword("abc").stringValue() }
        }

        "input: a1" {
            ValidPassword("a1").valid() shouldBe false
            ValidPassword("a1").violation() shouldBe "The password must contain at least 2 numbers"
            shouldThrow<IllegalStateException> { ValidPassword("a1").stringValue() }
        }
    }
})
