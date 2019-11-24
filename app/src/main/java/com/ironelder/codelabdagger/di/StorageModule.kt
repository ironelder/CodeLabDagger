package com.ironelder.codelabdagger.di


import com.ironelder.codelabdagger.storage.SharedPreferencesStorage
import com.ironelder.codelabdagger.storage.Storage
import dagger.Binds
import dagger.Module

@Module
abstract class StorageModule {
    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}