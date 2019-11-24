package com.ironelder.codelabdagger

import android.app.Application
import com.ironelder.codelabdagger.di.AppComponent
import com.ironelder.codelabdagger.di.DaggerAppComponent
import com.ironelder.codelabdagger.storage.SharedPreferencesStorage
import com.ironelder.codelabdagger.user.UserManager

open class MyApplication : Application() {

    val appComponent:AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

}
