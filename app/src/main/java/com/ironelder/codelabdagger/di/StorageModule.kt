package com.ironelder.codelabdagger.di


import android.content.Context
import com.ironelder.codelabdagger.storage.SharedPreferencesStorage
import com.ironelder.codelabdagger.storage.Storage
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class RegistrationStorage

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class LoginStorage


@Module
class StorageModule {
    @RegistrationStorage
    @Provides
    fun provideRegistrationStorage(context: Context): Storage {
        return SharedPreferencesStorage("registration", context)
    }

    @LoginStorage
    @Provides
    fun provideLoginStorage(context: Context): Storage {
        return SharedPreferencesStorage("login", context)
    }
}

// In a method
class ClassDependingOnStorage(@RegistrationStorage private val storage: Storage) {

}

// As an injected field
class ClassDependingOnStorageSub {

    @Inject
    @field:RegistrationStorage lateinit var storage: Storage
}