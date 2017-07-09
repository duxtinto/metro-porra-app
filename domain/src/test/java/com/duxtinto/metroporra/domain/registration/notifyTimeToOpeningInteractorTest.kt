package com.duxtinto.metroporra.domain.registration

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.assertj.core.api.Assertions.assertThat

internal class notifyTimeToOpeningInteractorTest {

    private var sutInteractor: NotifyTimeToOpeningInteractor? = null

    @BeforeEach
    fun setUp() {
        sutInteractor = NotifyTimeToOpeningInteractor()
    }

    @Test
    fun constructor() {
        assertThat<NotifyTimeToOpeningInteractor>(sutInteractor).isInstanceOf(NotifyTimeToOpeningInteractor::class)
    }
}
