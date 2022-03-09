package com.github.lette1394.password.validator

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.github.lette1394.password.validator.FailedReasons.Companion.reasons
import com.github.lette1394.password.validator.FailedReasons.Reason.PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_CAPITAL_LETTER
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertAll

class AllPasswordPolicyTest : FreeSpec({
    "pass" {
        val expected = Unit.right()
        assertAll({
            AllPasswordPolicy(Pass()).matches(anyPassword()) shouldBe expected
            AllPasswordPolicy(Pass(), Pass()).matches(anyPassword()) shouldBe expected
            AllPasswordPolicy(Pass(), Pass(), Pass()).matches(anyPassword()) shouldBe expected
        })
    }

    "fail" {
        val expected = anyReasons().left()
        assertAll({
            AllPasswordPolicy(Fail()).matches(anyPassword()) shouldBe expected
            AllPasswordPolicy(Pass(), Fail()).matches(anyPassword()) shouldBe expected
            AllPasswordPolicy(Pass(), Fail(), Fail()).matches(anyPassword()) shouldBe expected
            AllPasswordPolicy(Pass(), Pass(), Fail()).matches(anyPassword()) shouldBe expected
            AllPasswordPolicy(Pass(), Pass(), Pass(), Fail()).matches(anyPassword()) shouldBe expected
            AllPasswordPolicy(Fail(), Pass(), Pass(), Fail()).matches(anyPassword()) shouldBe expected
            AllPasswordPolicy(Fail(), Fail(), Fail(), Fail()).matches(anyPassword()) shouldBe expected
            AllPasswordPolicy(Fail(), Fail(), Pass(), Fail()).matches(anyPassword()) shouldBe expected
        })
    }
})


class Pass : PasswordPolicy {
    override fun matches(value: String): Either<FailedReasons, Unit> {
        return Unit.right()
    }
}

class Fail : PasswordPolicy {
    override fun matches(value: String): Either<FailedReasons, Unit> {
        return anyReasons().left()
    }
}

private fun anyReasons() = reasons(PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_CAPITAL_LETTER)
private fun anyPassword() = "<any-password>"
