package com.tjtjrb.bottles

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class BottlesTest {
    @Test
    fun `can print a single "normal" verse`() {
        assertThat(Bottles().verse(5)).isEqualTo("""{}""")
    }
}