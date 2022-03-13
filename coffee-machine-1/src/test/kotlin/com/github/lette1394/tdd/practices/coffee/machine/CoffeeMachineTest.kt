package com.github.lette1394.tdd.practices.coffee.machine

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifySequence

class CoffeeMachineTest : FreeSpec({

    "T:1:0" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val emailNotifier = mockk<EmailNotifier>(relaxed = true)
        val beverageQuantityChecker = mockk<BeverageQuantityChecker>(relaxed = true) {
            every { isEmpty(any()) } returns false
        }
        val coffeeMachine = CoffeeMachine(drinkMaker, emailNotifier, beverageQuantityChecker)
        coffeeMachine.insertCoin(400)
        coffeeMachine.handle(Tea(1, false))

        verifySequence {
            drinkMaker.receives("T:1:0")
        }
    }

    "Th:1:0" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val emailNotifier = mockk<EmailNotifier>(relaxed = true)
        val beverageQuantityChecker = mockk<BeverageQuantityChecker>(relaxed = true) {
            every { isEmpty(any()) } returns false
        }
        val coffeeMachine = CoffeeMachine(drinkMaker, emailNotifier, beverageQuantityChecker)
        coffeeMachine.insertCoin(400)
        coffeeMachine.handle(Tea(1, true))

        verifySequence {
            drinkMaker.receives("Th:1:0")
        }
    }

    "H::" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val emailNotifier = mockk<EmailNotifier>(relaxed = true)
        val beverageQuantityChecker = mockk<BeverageQuantityChecker>(relaxed = true) {
            every { isEmpty(any()) } returns false
        }
        val coffeeMachine = CoffeeMachine(drinkMaker, emailNotifier, beverageQuantityChecker)
        coffeeMachine.insertCoin(500)
        coffeeMachine.handle(Chocolate(0, false))

        verifySequence {
            drinkMaker.receives("H::")
        }
    }

    "Hh::" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val emailNotifier = mockk<EmailNotifier>(relaxed = true)
        val beverageQuantityChecker = mockk<BeverageQuantityChecker>(relaxed = true) {
            every { isEmpty(any()) } returns false
        }
        val coffeeMachine = CoffeeMachine(drinkMaker, emailNotifier, beverageQuantityChecker)
        coffeeMachine.insertCoin(500)
        coffeeMachine.handle(Chocolate(0, true))

        verifySequence {
            drinkMaker.receives("Hh::")
        }
    }

    "C:2:0" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val emailNotifier = mockk<EmailNotifier>(relaxed = true)
        val beverageQuantityChecker = mockk<BeverageQuantityChecker>(relaxed = true) {
            every { isEmpty(any()) } returns false
        }
        val coffeeMachine = CoffeeMachine(drinkMaker, emailNotifier, beverageQuantityChecker)
        coffeeMachine.insertCoin(600)
        coffeeMachine.handle(Coffee(2, false))

        verifySequence {
            drinkMaker.receives("C:2:0")
        }
    }

    "Ch:2:0" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val emailNotifier = mockk<EmailNotifier>(relaxed = true)
        val beverageQuantityChecker = mockk<BeverageQuantityChecker>(relaxed = true) {
            every { isEmpty(any()) } returns false
        }
        val coffeeMachine = CoffeeMachine(drinkMaker, emailNotifier, beverageQuantityChecker)
        coffeeMachine.insertCoin(600)
        coffeeMachine.handle(Coffee(2, true))

        verifySequence {
            drinkMaker.receives("Ch:2:0")
        }
    }

    "O::" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val emailNotifier = mockk<EmailNotifier>(relaxed = true)
        val beverageQuantityChecker = mockk<BeverageQuantityChecker>(relaxed = true) {
            every { isEmpty(any()) } returns false
        }
        val coffeeMachine = CoffeeMachine(drinkMaker, emailNotifier, beverageQuantityChecker)
        coffeeMachine.insertCoin(600)
        coffeeMachine.handle(OrangeJuice)

        verifySequence {
            drinkMaker.receives("O::")
        }
    }

    "M:message-content" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val emailNotifier = mockk<EmailNotifier>(relaxed = true)
        val beverageQuantityChecker = mockk<BeverageQuantityChecker>(relaxed = true) {
            every { isEmpty(any()) } returns false
        }
        val coffeeMachine = CoffeeMachine(drinkMaker, emailNotifier, beverageQuantityChecker)
        coffeeMachine.handle(Message("message-content"))

        verifySequence {
            drinkMaker.receives("M:message-content")
        }
    }

    "no coin for tee" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val emailNotifier = mockk<EmailNotifier>(relaxed = true)
        val beverageQuantityChecker = mockk<BeverageQuantityChecker>(relaxed = true) {
            every { isEmpty(any()) } returns false
        }
        val coffeeMachine = CoffeeMachine(drinkMaker, emailNotifier, beverageQuantityChecker)
        coffeeMachine.insertCoin(390)
        coffeeMachine.handle(Tea(1, false))

        verifySequence {
            drinkMaker.receives("M:10원이 부족합니다")
        }
    }

    "no coin for coffee" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val emailNotifier = mockk<EmailNotifier>(relaxed = true)
        val beverageQuantityChecker = mockk<BeverageQuantityChecker>(relaxed = true) {
            every { isEmpty(any()) } returns false
        }
        val coffeeMachine = CoffeeMachine(drinkMaker, emailNotifier, beverageQuantityChecker)
        coffeeMachine.insertCoin(390)
        coffeeMachine.handle(Coffee(2, true))

        verifySequence {
            drinkMaker.receives("M:210원이 부족합니다")
        }
    }

    "report 1" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val emailNotifier = mockk<EmailNotifier>(relaxed = true)
        val beverageQuantityChecker = mockk<BeverageQuantityChecker>(relaxed = true) {
            every { isEmpty(any()) } returns false
        }
        val coffeeMachine = CoffeeMachine(drinkMaker, emailNotifier, beverageQuantityChecker)
        coffeeMachine.insertCoin(600)
        coffeeMachine.handle(Coffee(2, true))

        coffeeMachine.insertCoin(600)
        coffeeMachine.handle(Coffee(2, true))

        coffeeMachine.insertCoin(600)
        coffeeMachine.handle(Coffee(2, true))

        coffeeMachine.report() shouldBe "tea:0, chocolate:0, coffee:3, orange juice:0, total:3, money earned: 1800"
    }

    "report 2" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val emailNotifier = mockk<EmailNotifier>(relaxed = true)
        val beverageQuantityChecker = mockk<BeverageQuantityChecker>(relaxed = true) {
            every { isEmpty(any()) } returns false
        }
        val coffeeMachine = CoffeeMachine(drinkMaker, emailNotifier, beverageQuantityChecker)
        coffeeMachine.insertCoin(400)
        coffeeMachine.handle(Tea(2, false))

        coffeeMachine.insertCoin(500)
        coffeeMachine.handle(Chocolate(2, true))

        coffeeMachine.insertCoin(500)
        coffeeMachine.handle(Chocolate(1, false))

        coffeeMachine.insertCoin(600)
        coffeeMachine.handle(Coffee(2, true))

        coffeeMachine.insertCoin(600)
        coffeeMachine.handle(OrangeJuice)

        coffeeMachine.report() shouldBe "tea:1, chocolate:2, coffee:1, orange juice:1, total:5, money earned: 2600"
    }

    "shotage" {
        val drinkMaker = mockk<DrinkMaker>(relaxed = true)
        val emailNotifier = mockk<EmailNotifier>(relaxed = true)
        val beverageQuantityChecker = mockk<BeverageQuantityChecker>(relaxed = true) {
            every { isEmpty(any()) } returns true
        }
        val coffeeMachine = CoffeeMachine(drinkMaker, emailNotifier, beverageQuantityChecker)

        coffeeMachine.insertCoin(400)
        coffeeMachine.handle(Tea(2, false))

        verifySequence {
            emailNotifier.notifyMissingDrink("T")
            drinkMaker.receives("M:품절입니다")
        }
    }
})
