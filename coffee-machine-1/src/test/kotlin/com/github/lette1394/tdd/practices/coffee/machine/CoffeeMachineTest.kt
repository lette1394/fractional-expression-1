package com.github.lette1394.tdd.practices.coffee.machine

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CoffeeMachineTest : FreeSpec({

    "T:1:0" {
        CoffeeMachine().translate(Tea(1)) shouldBe "T:1:0"
    }

    "H::" {
        CoffeeMachine().translate(Chocolate(0)) shouldBe "H::"
    }

    "C:2:0" {
        CoffeeMachine().translate(Coffee(2)) shouldBe "C:2:0"
    }

    "M:message-content" {
        CoffeeMachine().translate(Message("message-content")) shouldBe "M:message-content"
    }
})
