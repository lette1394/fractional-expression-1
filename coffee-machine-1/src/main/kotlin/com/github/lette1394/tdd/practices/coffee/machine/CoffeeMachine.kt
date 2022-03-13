package com.github.lette1394.tdd.practices.coffee.machine

class CoffeeMachine {

    fun translate(order: Order): String {
        return when (order) {
            is Tea -> {
                val sugar = if (order.sugar > 0) "${order.sugar}" else ""
                val stirring = if (order.sugar > 0) "0" else ""

                "T:$sugar:$stirring"
            }
            is Chocolate -> {
                val sugar = if (order.sugar > 0) "${order.sugar}" else ""
                val stirring = if (order.sugar > 0) "0" else ""

                "H:$sugar:$stirring"
            }
            is Coffee -> {
                val sugar = if (order.sugar > 0) "${order.sugar}" else ""
                val stirring = if (order.sugar > 0) "0" else ""

                "C:$sugar:$stirring"
            }
            is Message -> "M:${order.contents}"
        }
    }
}
