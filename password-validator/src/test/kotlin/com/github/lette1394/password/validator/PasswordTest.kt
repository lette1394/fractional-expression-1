package com.github.lette1394.password.validator

import arrow.core.Either.Left
import arrow.core.Either.Right
import com.github.lette1394.password.validator.Reasons.Companion.reasons
import com.github.lette1394.password.validator.Reasons.Reason.PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS
import com.github.lette1394.password.validator.Reasons.Reason.PASSWORD_MUST_CONTAIN_AT_LEAST_2_NUMBERS
import com.github.lette1394.password.validator.Reasons.Reason.PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_CAPITAL_LETTER
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class PasswordTest : FreeSpec({
    "Password must be at least 8 characters - 1" {
        Password.create("12345678A").map { it.asString() } shouldBe Right("12345678A")
    }

    "Password must be at least 8 characters - 2" {
        Password.create("123456A") shouldBe Left(reasons(PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS))
    }

    "Password must be at least 8 characters - 3" {
        Password.create("") shouldBe Left(
            reasons(
                PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS,
                PASSWORD_MUST_CONTAIN_AT_LEAST_2_NUMBERS,
                PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_CAPITAL_LETTER,
            )
        )
    }

    "The password must contain at least 2 numbers - 1" {
        Password.create("abCd1234").map { it.asString() } shouldBe Right("abCd1234")
    }

    "The password must contain at least 2 numbers - 2" {
        Password.create("abcdEfgh") shouldBe Left(reasons(PASSWORD_MUST_CONTAIN_AT_LEAST_2_NUMBERS))
    }

    "password must contain at least one capital letter - 1" {
        Password.create("abcdefgh1234") shouldBe Left(reasons(PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_CAPITAL_LETTER))
    }
})
