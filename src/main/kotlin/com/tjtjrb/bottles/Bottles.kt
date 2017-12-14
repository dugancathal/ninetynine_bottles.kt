package com.tjtjrb.bottles

class Bottles {
    fun verse(number: Int): String {
        return """
            ${quantity(number).capitalize()} ${container(number)} of beer on the wall, ${quantity(number)} ${container(number)} of beer.
            ${action(number)}, ${quantity(next(number))} ${container(next(number))} of beer on the wall.
        """.trimIndent()
    }

    private fun action(number: Int): String {
        return if (number == 0)
            "Go to the store and buy some more"
        else
            "Take ${pronoun(number)} down and pass it around"
    }

    private fun next(number: Int): Int {
        return if (number == 0)
            99
        else
            number - 1
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