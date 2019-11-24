package com.ironelder.codelabdagger.login

import com.ironelder.codelabdagger.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():LoginComponent
    }

    fun inject(activity: LoginActivity)
}