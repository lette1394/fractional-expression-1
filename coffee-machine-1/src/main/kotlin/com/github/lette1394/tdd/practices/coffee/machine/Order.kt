package com.github.lette1394.tdd.practices.coffee.machine

sealed interface Order

data class Tea(val sugar: Int): Order
data class Chocolate(val sugar: Int): Order
data class Coffee(val sugar: Int): Order
data class Message(val contents: String): Order

