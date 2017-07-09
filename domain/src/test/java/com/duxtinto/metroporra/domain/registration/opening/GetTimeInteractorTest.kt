package com.duxtinto.metroporra.domain.registration.opening

import com.duxtinto.metroporra.data.registration.RegistrationInformationProvider
import io.kotlintest.matchers.beOfType
import io.kotlintest.matchers.beTheSameInstanceAs
import io.kotlintest.matchers.should
import io.kotlintest.mock.`when`
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import java.time.LocalDate

internal class GetTimeInteractorTest {

    @Mock
    lateinit var registrationInformation : RegistrationInformationProvider

    val scheduler : TestScheduler = TestScheduler()

    lateinit var sutInteractor: GetTimeInteractor

    @BeforeEach
    fun setUp() {
        sutInteractor = GetTimeInteractor()
    }

    @Test
    fun constructor() {
        sutInteractor should beOfType<GetTimeInteractor>()
    }

    @Test
    fun execute_ifOpeningPeriodIsAvailable_shouldEmitIt() {
        val expectedOpeningDate = LocalDate.of(20, 11, 2017)
        `when`(registrationInformation.getOpeningDate())
                .thenReturn(Single.just(expectedOpeningDate))

        val result : Single<LocalDate> = sutInteractor.execute()

        result
                .subscribeOn(scheduler)
                .observeOn(scheduler)
                .doOnSuccess { date : LocalDate -> date should beTheSameInstanceAs(expectedOpeningDate) }

        scheduler.triggerActions()
    }
}
