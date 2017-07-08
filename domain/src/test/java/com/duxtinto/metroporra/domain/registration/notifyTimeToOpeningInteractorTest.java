package com.duxtinto.metroporra.domain.registration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class notifyTimeToOpeningInteractorTest {

    private NotifyTimeToOpeningInteractor sutInteractor;

    @BeforeEach
    void setUp() {
        sutInteractor = new NotifyTimeToOpeningInteractor();
    }

    @Test
    void constructor() {
        assertThat(sutInteractor).isInstanceOf(NotifyTimeToOpeningInteractor.class);
    }
}
