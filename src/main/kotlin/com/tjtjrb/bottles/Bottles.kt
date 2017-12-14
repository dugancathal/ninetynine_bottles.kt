package com.tjtjrb.bottles

class Bottles {
    fun verses(start: Int, end: Int): String? {
        return start.downTo(end).joinToString("\n") { verse(it) }
    }

    fun verse(number: Int): String {
        val bottleNumber = BottleNumber.forNum(number)
        val nextBottleNumber = BottleNumber.forNum(BottleNumber.forNum(number).next())
        return """
            ${bottleNumber.quantity().capitalize()} ${bottleNumber.container()} of beer on the wall,
            ${bottleNumber.quantity()} ${bottleNumber.container()} of beer.
            ${bottleNumber.action()},
            ${nextBottleNumber.quantity()} ${nextBottleNumber.container()} of beer on the wall.
        """.trimIndent()
    }
}

open class BottleNumber(private val number: Int) {
    companion object {
        fun forNum(number: Int): BottleNumber {
            return if (number == 0) {
                BottleNumber0(number)
            } else if (number == 1) {
                BottleNumber1(number)
            } else {
                BottleNumber(number)
            }
        }
    }

    open fun action(): String = "Take ${pronoun()} down and pass it around"
    open fun quantity(): String = "$number"
    open fun next(): Int = number - 1

    open fun container(): String = "bottles"
    open fun pronoun(): String = "one"
}

class BottleNumber0(number: Int) : BottleNumber(number) {
    override fun action(): String = "Go to the store and buy some more"
    override fun next(): Int = 99
    override fun quantity(): String = "no more"
}

class BottleNumber1(number: Int) : BottleNumber(number) {
    override fun container(): String = "bottle"
    override fun pronoun(): String = "it"
}