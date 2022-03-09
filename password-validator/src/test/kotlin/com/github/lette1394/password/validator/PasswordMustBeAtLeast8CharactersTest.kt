package com.github.lette1394.password.validator

import arrow.core.Either.Left
import arrow.core.Either.Right
import com.github.lette1394.password.validator.FailedReasons.Companion.reasons
import com.github.lette1394.password.validator.FailedReasons.Reason.PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertAll

class PasswordMustBeAtLeast8CharactersTest : FreeSpec({
    val subject = PasswordMustBeAtLeast8Characters()

    "pass" {
        val expected = Right(Unit)
        assertAll({
            subject.matches("12345678") shouldBe expected
            subject.matches("abcdefgh") shouldBe expected
            subject.matches("58gvi13n") shouldBe expected
            subject.matches("00000000") shouldBe expected
            subject.matches("000000000") shouldBe expected
        })
    }

    "fail" {
        val expected = Left(reasons(PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS))
        assertAll({
            subject.matches("") shouldBe expected
            subject.matches("1") shouldBe expected
            subject.matches("1234567") shouldBe expected
            subject.matches("abcdedf") shouldBe expected
        })
    }
})
