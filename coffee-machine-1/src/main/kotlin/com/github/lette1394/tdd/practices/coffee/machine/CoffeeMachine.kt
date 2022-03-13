package com.github.lette1394.tdd.practices.coffee.machine

class CoffeeMachine(private val drinkMaker: DrinkMaker) {
    private var remainingCoins = 0L

    fun insertCoin(won: Long) {
        remainingCoins += won
    }

    fun handle(order: Order) {
        drinkMaker.receives(translate(order))
    }

    private fun translate(order: Order): String {
        return when (order) {
            is Tea -> {
                // 400원
                val sugar = if (order.sugar > 0) "${order.sugar}" else ""
                val stirring = if (order.sugar > 0) "0" else ""

                "T:$sugar:$stirring"
            }
            is Chocolate -> {
                // 500원
                val sugar = if (order.sugar > 0) "${order.sugar}" else ""
                val stirring = if (order.sugar > 0) "0" else ""

                "H:$sugar:$stirring"
            }
            is Coffee -> {
                // 600원
                val sugar = if (order.sugar > 0) "${order.sugar}" else ""
                val stirring = if (order.sugar > 0) "0" else ""

                "C:$sugar:$stirring"
            }
            is Message -> "M:${order.contents}"
        }
    }
}
