package com.tjtjrb.bottles

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class BottlesTest {
    @Test
    fun `can print a single "normal" verse`() {
        assertThat(Bottles().verse(5)).isEqualTo("""
            5 bottles of beer on the wall,
            5 bottles of beer.
            Take one down and pass it around,
            4 bottles of beer on the wall.
        """.trimIndent())
    }

    @Test
    fun `can print verse the first verse`() {
        assertThat(Bottles().verse(99)).isEqualTo("""
            99 bottles of beer on the wall,
            99 bottles of beer.
            Take one down and pass it around,
            98 bottles of beer on the wall.
        """.trimIndent())
    }

    @Test
    fun `can print verse number 2`() {
        assertThat(Bottles().verse(2)).isEqualTo("""
            2 bottles of beer on the wall,
            2 bottles of beer.
            Take one down and pass it around,
            1 bottle of beer on the wall.
        """.trimIndent())
    }

    @Test
    fun `can print verse number 1`() {
        assertThat(Bottles().verse(1)).isEqualTo("""
            1 bottle of beer on the wall,
            1 bottle of beer.
            Take it down and pass it around,
            no more bottles of beer on the wall.
        """.trimIndent())
    }

    @Test
    fun `can print the restart verse (last verse)`() {
        assertThat(Bottles().verse(0)).isEqualTo("""
            No more bottles of beer on the wall,
            no more bottles of beer.
            Go to the store and buy some more,
            99 bottles of beer on the wall.
        """.trimIndent())
    }

    @Test
    fun `can print multiple verses between bounds`() {
        assertThat(Bottles().verses(99, 98)).isEqualTo("""
            99 bottles of beer on the wall,
            99 bottles of beer.
            Take one down and pass it around,
            98 bottles of beer on the wall.
            98 bottles of beer on the wall,
            98 bottles of beer.
            Take one down and pass it around,
            97 bottles of beer on the wall.
        """.trimIndent())
    }

    @Test
    fun `return 'six-pack' instead of 6 bottles`() {
        assertThat(Bottles().verses(7, 6)).isEqualTo("""
            7 bottles of beer on the wall,
            7 bottles of beer.
            Take one down and pass it around,
            1 six-pack of beer on the wall.
            1 six-pack of beer on the wall,
            1 six-pack of beer.
            Take one down and pass it around,
            5 bottles of beer on the wall.
        """.trimIndent())
    }
}