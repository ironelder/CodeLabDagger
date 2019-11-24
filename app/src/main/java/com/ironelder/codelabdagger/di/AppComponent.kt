package com.ironelder.codelabdagger.di

import android.content.Context
import com.ironelder.codelabdagger.main.MainActivity
import com.ironelder.codelabdagger.registration.RegistrationComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class, AppSubComponents::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun registrationComponent(): RegistrationComponent.Factory
    fun inject(activity: MainActivity)
}