package com.ironelder.codelabdagger.user

import com.ironelder.codelabdagger.main.MainActivity
import com.ironelder.codelabdagger.settings.SettingsActivity
import dagger.Subcomponent

@LoggedUserScope
@Subcomponent
interface UserComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():UserComponent
    }

    fun inject(activity: SettingsActivity)
    fun inject(activity: MainActivity)
}