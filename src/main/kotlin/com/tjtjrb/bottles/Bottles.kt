package com.tjtjrb.bottles

class Bottles {
    fun verses(start: Int, end: Int): String? {
        return start.downTo(end).joinToString("\n") { verse(it) }
    }

    fun verse(number: Int): String {
        val bottleNumber = BottleNumber.forNum(number)
        return "$bottleNumber of beer on the wall,\n".capitalize() +
                "$bottleNumber of beer.\n" +
                "${bottleNumber.action()},\n" +
                "${bottleNumber.next()} of beer on the wall."
    }
}

open class BottleNumber(private val number: Int) {
    companion object {
        fun forNum(number: Int): BottleNumber {
            return try {
                Class.forName("${this::class.java.`package`.name}.BottleNumber$number").newInstance() as BottleNumber
            } catch (e: ClassNotFoundException) {
                BottleNumber(number)
            }
        }
    }

    open fun action(): String = "Take ${pronoun()} down and pass it around"
    open fun quantity(): String = "$number"
    open fun next(): BottleNumber = BottleNumber.forNum(number - 1)

    open fun container(): String = "bottles"
    open fun pronoun(): String = "one"

    override fun toString(): String = "${quantity()} ${container()}"
}

class BottleNumber0 : BottleNumber(0) {
    override fun action(): String = "Go to the store and buy some more"
    override fun next(): BottleNumber = BottleNumber.forNum(99)
    override fun quantity(): String = "no more"
}

class BottleNumber1 : BottleNumber(1) {
    override fun container(): String = "bottle"
    override fun pronoun(): String = "it"
}

class BottleNumber6 : BottleNumber(6) {
    override fun container(): String = "six-pack"
    override fun quantity(): String = "1"
}