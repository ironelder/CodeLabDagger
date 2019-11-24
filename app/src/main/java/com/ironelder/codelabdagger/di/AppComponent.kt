package com.ironelder.codelabdagger.di

import android.content.Context
import com.ironelder.codelabdagger.login.LoginComponent
import com.ironelder.codelabdagger.registration.RegistrationComponent
import com.ironelder.codelabdagger.user.UserComponent
import com.ironelder.codelabdagger.user.UserManager
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
    fun loginComponent(): LoginComponent.Factory
    fun userManager(): UserManager
}