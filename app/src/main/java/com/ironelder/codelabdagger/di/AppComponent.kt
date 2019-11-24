package com.ironelder.codelabdagger.di

import android.content.Context
import com.ironelder.codelabdagger.main.MainActivity
import com.ironelder.codelabdagger.registration.RegistrationActivity
import com.ironelder.codelabdagger.registration.enterdetails.EnterDetailsFragment
import com.ironelder.codelabdagger.registration.termsandconditions.TermsAndConditionsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
    fun inject(activity: MainActivity)
    fun inject(activity: RegistrationActivity)
    fun inject(fragment: TermsAndConditionsFragment)
    fun inject(fragment: EnterDetailsFragment)
}