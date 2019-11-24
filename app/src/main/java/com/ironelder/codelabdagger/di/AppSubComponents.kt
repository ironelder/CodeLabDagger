package com.ironelder.codelabdagger.di

import com.ironelder.codelabdagger.login.LoginComponent
import com.ironelder.codelabdagger.registration.RegistrationComponent
import com.ironelder.codelabdagger.user.UserComponent
import dagger.Module

@Module(subcomponents = [RegistrationComponent::class, LoginComponent::class, UserComponent::class])
class AppSubComponents {
}