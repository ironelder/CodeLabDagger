package com.ironelder.codelabdagger.registration

import com.ironelder.codelabdagger.di.ActivityScope
import com.ironelder.codelabdagger.registration.enterdetails.EnterDetailsFragment
import com.ironelder.codelabdagger.registration.termsandconditions.TermsAndConditionsFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface RegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }

    fun inject(activity: RegistrationActivity)
    fun inject(fragment: EnterDetailsFragment)
    fun inject(fragment: TermsAndConditionsFragment)
}