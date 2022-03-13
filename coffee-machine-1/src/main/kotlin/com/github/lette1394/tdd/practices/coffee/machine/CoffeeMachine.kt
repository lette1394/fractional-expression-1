package com.github.lette1394.tdd.practices.coffee.machine

class CoffeeMachine(
    private val drinkMaker: DrinkMaker,
    private val emailNotifier: EmailNotifier,
    private val beverageQuantityChecker: BeverageQuantityChecker,
) {

    private var remainingCoins = 0L
    private var tea: Long = 0
    private var chocolate: Long = 0
    private var coffee: Long = 0
    private var orangeJuice: Long = 0

    fun insertCoin(won: Long) {
        remainingCoins += won
    }

    fun handle(order: Order) {
        drinkMaker.receives(translate(order))
    }

    fun report(): String {
        val total = tea + chocolate + coffee + orangeJuice
        val earned = tea * 400 + chocolate * 500 + coffee * 600 + orangeJuice * 600
        return "tea:$tea, chocolate:$chocolate, coffee:$coffee, orange juice:$orangeJuice, total:$total, money earned: $earned"
    }

    private fun translate(order: Order): String {
        return when (order) {
            is Tea -> tea(order)
            is Chocolate -> chocolate(order)
            is Coffee -> coffee(order)
            is OrangeJuice -> orangeJuice()
            is Message -> "M:${order.contents}"
        }
    }

    private fun tea(order: Tea): String {
        if (beverageQuantityChecker.isEmpty("T")) {
            emailNotifier.notifyMissingDrink("T")
            return "M:품절입니다"
        }

        if (remainingCoins >= 400) {
            val sugar = if (order.sugar > 0) "${order.sugar}" else ""
            val stirring = if (order.sugar > 0) "0" else ""
            val extraHot = if (order.extraHot) "h" else ""

            tea++
            return "T$extraHot:$sugar:$stirring"
        }

        return "M:${400 - remainingCoins}원이 부족합니다"
    }

    private fun chocolate(order: Chocolate): String {
        if (beverageQuantityChecker.isEmpty("H")) {
            emailNotifier.notifyMissingDrink("H")
            return "M:품절입니다"
        }

        if (remainingCoins >= 500) {
            val sugar = if (order.sugar > 0) "${order.sugar}" else ""
            val stirring = if (order.sugar > 0) "0" else ""
            val extraHot = if (order.extraHot) "h" else ""

            chocolate++
            return "H$extraHot:$sugar:$stirring"
        }

        return "M:${500 - remainingCoins}원이 부족합니다"
    }

    private fun coffee(order: Coffee): String {
        if (beverageQuantityChecker.isEmpty("C")) {
            emailNotifier.notifyMissingDrink("C")
            return "M:품절입니다"
        }

        if (remainingCoins >= 600) {
            val sugar = if (order.sugar > 0) "${order.sugar}" else ""
            val stirring = if (order.sugar > 0) "0" else ""
            val extraHot = if (order.extraHot) "h" else ""

            coffee++
            return "C$extraHot:$sugar:$stirring"
        }

        return "M:${600 - remainingCoins}원이 부족합니다"
    }

    private fun orangeJuice(): String {
        if (remainingCoins >= 600) {
            orangeJuice++
            return "O::"
        }

        return "M:${600 - remainingCoins}원이 부족합니다"
    }
}
