package com.github.lette1394.tdd.practices.password.validator

import arrow.core.Either.Left
import arrow.core.Either.Right
import com.github.lette1394.password.validator.FailedReasons.Companion.reasons
import com.github.lette1394.password.validator.FailedReasons.Reason.PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_SPECIAL_CHARACTER
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertAll

class PasswordMustContainAtLeastOneSpecialCharacterTest : FreeSpec({
    fun anyPassword(): String = "<any-password>"

    val have = { _: String -> true }
    val notHave = { _: String -> false }

    "pass" {
        assertAll({
            PasswordMustContainAtLeastOneSpecialCharacter(have).matches(anyPassword()) shouldBe Right(Unit)
        })
    }

    "fail" {
        val expected = Left(reasons(PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_SPECIAL_CHARACTER))
        assertAll({
            PasswordMustContainAtLeastOneSpecialCharacter(notHave).matches(anyPassword()) shouldBe expected
        })
    }
})
