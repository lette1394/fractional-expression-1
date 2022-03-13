package com.github.lette1394.tdd.practices.coffee.machine

class CoffeeMachine(private val drinkMaker: DrinkMaker) {
    private var remainingCoins = 0L

    fun insertCoin(won: Long) {
        remainingCoins += won
    }

    fun handle(order: Order) {
        drinkMaker.receives(translate(order))
    }

    fun report(): String {
        return "tea: 1"
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

    private fun orangeJuice(): String {
        if (remainingCoins >= 600) {
            return "O::"
        }

        return "M:${600 - remainingCoins}원이 부족합니다"
    }

    private fun coffee(order: Coffee): String {
        if (remainingCoins >= 600) {
            val sugar = if (order.sugar > 0) "${order.sugar}" else ""
            val stirring = if (order.sugar > 0) "0" else ""
            val extraHot = if (order.extraHot) "h" else ""

            return "C$extraHot:$sugar:$stirring"
        }

        return "M:${600 - remainingCoins}원이 부족합니다"
    }

    private fun chocolate(order: Chocolate): String {
        if (remainingCoins >= 500) {
            val sugar = if (order.sugar > 0) "${order.sugar}" else ""
            val stirring = if (order.sugar > 0) "0" else ""
            val extraHot = if (order.extraHot) "h" else ""

            return "H$extraHot:$sugar:$stirring"
        }

        return "M:${500 - remainingCoins}원이 부족합니다"
    }

    private fun tea(order: Tea): String {
        if (remainingCoins >= 400) {
            val sugar = if (order.sugar > 0) "${order.sugar}" else ""
            val stirring = if (order.sugar > 0) "0" else ""
            val extraHot = if (order.extraHot) "h" else ""

            return "T$extraHot:$sugar:$stirring"
        }

        return "M:${400 - remainingCoins}원이 부족합니다"
    }
}
