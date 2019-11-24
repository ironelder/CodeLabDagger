package com.ironelder.codelabdagger.registration

import com.ironelder.codelabdagger.registration.enterdetails.EnterDetailsFragment
import com.ironelder.codelabdagger.registration.termsandconditions.TermsAndConditionsFragment
import dagger.Subcomponent


@Subcomponent
interface RegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun onCreate(): RegistrationComponent
    }

    fun inject(activity: RegistrationActivity)
    fun inject(fragment: EnterDetailsFragment)
    fun inject(fragment: TermsAndConditionsFragment)
}