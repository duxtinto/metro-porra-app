package com.duxtinto.metroporra.domain.registration.opening

import com.duxtinto.metroporra.data.registration.RegistrationInformationProvider
import io.reactivex.Single
import java.time.LocalDate

internal class GetTimeInteractor(val registrationInformation: RegistrationInformationProvider) {
    fun execute() : Single<LocalDate> {
        return registrationInformation.getOpeningDate()
    }
}
