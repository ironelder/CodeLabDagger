package com.ironelder.codelabdagger

import android.app.Application
import com.ironelder.codelabdagger.storage.SharedPreferencesStorage
import com.ironelder.codelabdagger.user.UserManager

open class MyApplication : Application() {

    open val userManager by lazy {
        UserManager(SharedPreferencesStorage(this))
    }
}
