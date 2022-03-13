package com.github.lette1394.tdd.practices.coffee.machine

import io.kotest.core.spec.style.FreeSpec
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifySequence

class CoffeeMachineTest : FreeSpec({
    "T:1:0" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        CoffeeMachine(drinkMaker).handle(Tea(1))

        verify {
            drinkMaker.receives("T:1:0")
        }
    }

    "H::" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        CoffeeMachine(drinkMaker).handle(Chocolate(0))

        verifySequence {
            drinkMaker.receives("H::")
        }
    }

    "C:2:0" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        CoffeeMachine(drinkMaker).handle(Coffee(2))

        verify {
            drinkMaker.receives("C:2:0")
        }
    }

    "M:message-content" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        CoffeeMachine(drinkMaker).handle(Message("message-content"))

        verify {
            drinkMaker.receives("M:message-content")
        }
    }
})
