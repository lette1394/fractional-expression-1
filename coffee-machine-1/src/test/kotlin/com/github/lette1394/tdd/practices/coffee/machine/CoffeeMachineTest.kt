package com.github.lette1394.tdd.practices.coffee.machine

import io.kotest.core.spec.style.FreeSpec
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifySequence

class CoffeeMachineTest : FreeSpec({
    "T:1:0" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val coffeeMachine = CoffeeMachine(drinkMaker)
        coffeeMachine.insertCoin(400)
        coffeeMachine.handle(Tea(1))

        verify {
            drinkMaker.receives("T:1:0")
        }
    }

    "H::" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val coffeeMachine = CoffeeMachine(drinkMaker)
        coffeeMachine.insertCoin(500)
        coffeeMachine.handle(Chocolate(0))

        verifySequence {
            drinkMaker.receives("H::")
        }
    }

    "C:2:0" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val coffeeMachine = CoffeeMachine(drinkMaker)
        coffeeMachine.insertCoin(600)
        coffeeMachine.handle(Coffee(2))

        verify {
            drinkMaker.receives("C:2:0")
        }
    }

    "M:message-content" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val coffeeMachine = CoffeeMachine(drinkMaker)
        coffeeMachine.handle(Message("message-content"))

        verify {
            drinkMaker.receives("M:message-content")
        }
    }

    "no coin" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val coffeeMachine = CoffeeMachine(drinkMaker)
        coffeeMachine.insertCoin(390)
        coffeeMachine.handle(Tea(1))

        verify {
            drinkMaker.receives("M:10원이 부족합니다")
        }
    }
})
