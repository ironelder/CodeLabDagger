package com.ironelder.codelabdagger.di

import com.ironelder.codelabdagger.login.LoginComponent
import com.ironelder.codelabdagger.registration.RegistrationComponent
import dagger.Module

@Module(subcomponents = [RegistrationComponent::class, LoginComponent::class])
class AppSubComponents {
}