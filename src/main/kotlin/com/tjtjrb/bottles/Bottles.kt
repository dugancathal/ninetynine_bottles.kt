package com.tjtjrb.bottles

class Bottles {
    fun verses(start: Int, end: Int): String? {
        return start.downTo(end).joinToString("\n") { verse(it) }
    }

    fun verse(number: Int): String {
        val bottleNumber = BottleNumber(number)
        val nextBottleNumber = BottleNumber(BottleNumber(number).next())
        return """
            ${bottleNumber.quantity().capitalize()} ${bottleNumber.container()} of beer on the wall,
            ${bottleNumber.quantity()} ${bottleNumber.container()} of beer.
            ${bottleNumber.action()},
            ${nextBottleNumber.quantity()} ${nextBottleNumber.container()} of beer on the wall.
        """.trimIndent()
    }
}

class BottleNumber(private val number: Int) {
    fun action(): String {
        return if (number == 0)
            "Go to the store and buy some more"
        else
            "Take ${pronoun()} down and pass it around"
    }

    fun next(): Int {
        return if (number == 0)
            99
        else
            number - 1
    }

    fun container(): String {
        return if (number == 1)
            "bottle"
        else
            "bottles"
    }

    fun pronoun(): String {
        return if (number == 1)
            "it"
        else
            "one"
    }

    fun quantity(): String {
        return if (number == 0)
            "no more"
        else
            "$number"
    }
}