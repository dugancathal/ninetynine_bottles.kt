package com.tjtjrb.bottles

class Bottles {
    fun verse(number: Int): String {
        return when (number) {
            0 -> """
                No more bottles of beer on the wall, no more bottles of beer.
                Go to the store and buy some more, 99 bottles of beer on the wall.
            """.trimIndent()
            else -> """
                $number ${container(number)} of beer on the wall, $number ${container(number)} of beer.
                Take ${pronoun(number)} down and pass it around, ${quantity(number - 1)} ${container(number - 1)} of beer on the wall.
            """.trimIndent()
        }
    }

    fun verses(start: Int, end: Int): String? {
        return start.downTo(end).joinToString("\n") { verse(it) }
    }

    private fun container(number: Int): String {
        return if (number == 1)
            "bottle"
        else
            "bottles"
    }

    private fun pronoun(number: Int): String {
        return if (number == 1)
            "it"
        else
            "one"
    }

    private fun quantity(number: Int): String {
        return if (number == 0)
            "no more"
        else
            "$number"
    }
}