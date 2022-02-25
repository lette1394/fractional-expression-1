package com.github.lette1394.password.validator

import arrow.core.Either.Left
import arrow.core.Either.Right
import com.github.lette1394.password.validator.Reasons.Companion.reasons
import com.github.lette1394.password.validator.Reasons.Reason.PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS
import com.github.lette1394.password.validator.Reasons.Reason.PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_CAPITAL_LETTER
import com.github.lette1394.password.validator.Reasons.Reason.THE_PASSWORD_MUST_CONTAIN_AT_LEAST_2_NUMBERS
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class PasswordTest : FreeSpec({
    "Password must be at least 8 characters - 1" {
        Password.create("12345678") shouldBe Right(Password("12345678"))
    }

    "Password must be at least 8 characters - 2" {
        Password.create("1234567") shouldBe Left(reasons(PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS))
    }

    "Password must be at least 8 characters - 3" {
        Password.create("") shouldBe Left(
            reasons(
                PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS,
                THE_PASSWORD_MUST_CONTAIN_AT_LEAST_2_NUMBERS
            )
        )
    }

    "The password must contain at least 2 numbers - 1" {
        Password.create("abcd1234") shouldBe Right(Password("abcd1234"))
    }

    "The password must contain at least 2 numbers - 2" {
        Password.create("abcdefgh") shouldBe Left(reasons(THE_PASSWORD_MUST_CONTAIN_AT_LEAST_2_NUMBERS))
    }

    "password must contain at least one capital letter - 1" {
        Password.create("abcdefgh1234") shouldBe Left(reasons(PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_CAPITAL_LETTER))
    }
})
