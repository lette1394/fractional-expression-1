package com.github.lette1394.password.validator

import arrow.core.Either.Left
import arrow.core.Either.Right
import com.github.lette1394.password.validator.FailedReasons.Companion.reasons
import com.github.lette1394.password.validator.FailedReasons.Reason.PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_CAPITAL_LETTER
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertAll

class PasswordMustContainAtLeastOneCapitalLetterTest : FreeSpec({
    val subject = PasswordMustContainAtLeastOneCapitalLetter()

    "pass" {
        val expected = Right(Unit)
        assertAll({
            subject.matches("A") shouldBe expected
            subject.matches("B") shouldBe expected
            subject.matches("C") shouldBe expected
            subject.matches("AAAA") shouldBe expected
            subject.matches("Aabbirbj") shouldBe expected
            subject.matches("zzzzzzzzZ") shouldBe expected
            subject.matches("zzZzzzzzZ") shouldBe expected
            subject.matches("zzZzZzzzZ") shouldBe expected
        })
    }

    "fail" {
        val expected = Left(reasons(PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_CAPITAL_LETTER))
        assertAll({
            subject.matches("") shouldBe expected
            subject.matches("1") shouldBe expected
            subject.matches("abc") shouldBe expected
            subject.matches("1abc") shouldBe expected
        })
    }
})
