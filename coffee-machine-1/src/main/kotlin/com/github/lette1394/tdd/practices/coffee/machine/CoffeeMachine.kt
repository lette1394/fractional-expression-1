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
                if (remainingCoins >= 400) {
                    val sugar = if (order.sugar > 0) "${order.sugar}" else ""
                    val stirring = if (order.sugar > 0) "0" else ""
                    val extraHot = if (order.extraHot) "h" else ""
                    return "T$extraHot:$sugar:$stirring"
                }

                "M:${400 - remainingCoins}원이 부족합니다"
            }
            is Chocolate -> {
                if (remainingCoins >= 500) {
                    val sugar = if (order.sugar > 0) "${order.sugar}" else ""
                    val stirring = if (order.sugar > 0) "0" else ""
                    val extraHot = if (order.extraHot) "h" else ""

                    return "H$extraHot:$sugar:$stirring"
                }

                "M:${500 - remainingCoins}원이 부족합니다"
            }
            is Coffee -> {
                if (remainingCoins >= 600) {
                    val sugar = if (order.sugar > 0) "${order.sugar}" else ""
                    val stirring = if (order.sugar > 0) "0" else ""
                    val extraHot = if (order.extraHot) "h" else ""

                    return "C$extraHot:$sugar:$stirring"
                }

                "M:${600 - remainingCoins}원이 부족합니다"
            }
            is OrangeJuice -> {
                if (remainingCoins >= 600) {
                    return "O::"
                }

                "M:${600 - remainingCoins}원이 부족합니다"
            }
            is Message -> "M:${order.contents}"
        }
    }
}
