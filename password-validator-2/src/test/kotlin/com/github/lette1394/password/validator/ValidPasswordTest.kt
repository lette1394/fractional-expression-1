package com.github.lette1394.password.validator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class ValidPasswordTest : FreeSpec({
    "Password must be at least 8 characters" - {
        "input: 1234578" {
            val subject = ValidPassword("12345678")
            subject.valid() shouldBe true
            subject.violation() shouldBe ""
            subject.stringValue() shouldBe "12345678"
        }

        "input: 123456789" {
            val subject = ValidPassword("123456789")
            subject.valid() shouldBe true
            subject.violation() shouldBe ""
            subject.stringValue() shouldBe "123456789"
        }

        "input: 123456789abcd" {
            val subject = ValidPassword("123456789abcd")
            subject.valid() shouldBe true
            subject.violation() shouldBe ""
            subject.stringValue() shouldBe "123456789abcd"
        }

        "input: (empty)" {
            val subject = ValidPassword("")
            subject.valid() shouldBe false
            subject.violation() shouldBe "Password must be at least 8 characters"
            shouldThrow<IllegalStateException> { subject.stringValue() }
        }

        "input: 1234567" {
            val subject = ValidPassword("1234567")
            subject.valid() shouldBe false
            subject.violation() shouldBe "Password must be at least 8 characters"
            shouldThrow<IllegalStateException> { subject.stringValue() }
        }
    }

    "The password must contain at least 2 numbers" - {
        "input: 12" {
            val subject = ValidPassword("12")
            subject.valid() shouldBe true
            subject.violation() shouldBe ""
            subject.stringValue() shouldBe "12"
        }

        "input: abc" {
            val subject = ValidPassword("abc")
            subject.valid() shouldBe false
            subject.violation() shouldBe "The password must contain at least 2 numbers"
            shouldThrow<IllegalStateException> { subject.stringValue() }
        }

        "input: a1" {
            val subject = ValidPassword("a1")
            subject.valid() shouldBe false
            subject.violation() shouldBe "The password must contain at least 2 numbers"
            shouldThrow<IllegalStateException> { subject.stringValue() }
        }
    }
})
