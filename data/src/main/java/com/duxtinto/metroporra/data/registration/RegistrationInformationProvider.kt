package com.duxtinto.metroporra.data.registration

import io.reactivex.Single
import java.time.LocalDate

class RegistrationInformationProvider {
    fun  getOpeningDate(): Single<LocalDate> {
        return Single.just(LocalDate.now())
    }
}