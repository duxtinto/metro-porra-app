package com.duxtinto.metroporra.domain.registration.opening

import com.duxtinto.metroporra.data.registration.RegistrationInformationProvider
import io.kotlintest.matchers.beOfType
import io.kotlintest.matchers.should
import io.kotlintest.mock.`when`
import io.reactivex.Single
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.time.LocalDate

internal class GetTimeInteractorTest {

    @Mock
    lateinit var registrationInformation: RegistrationInformationProvider

    lateinit var sutInteractor: GetTimeInteractor

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        sutInteractor = GetTimeInteractor(registrationInformation)
    }

    @Test
    fun constructor() {
        sutInteractor should beOfType<GetTimeInteractor>()
    }

    @Test
    fun execute_ifOpeningPeriodIsAvailable_shouldEmitIt() {
        val expectedOpeningDate = LocalDate.of(2017, 11, 20)
        `when`(registrationInformation.getOpeningDate())
                .thenReturn(Single.just(expectedOpeningDate))

        val testObserver = sutInteractor.execute().test()

        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertValueCount(1)
                .assertValue(expectedOpeningDate)
        Mockito.verify(registrationInformation).getOpeningDate()
    }
}
