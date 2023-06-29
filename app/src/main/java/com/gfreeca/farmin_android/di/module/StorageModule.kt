package com.gfreeca.farmin_android.di.module

import com.gfreeca.farmin_android.data.local.storage.AuthDataStorage
import com.gfreeca.farmin_android.data.local.storage.AuthDataStorageImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {
    @Binds
    abstract fun provideAuthDataStorage(
        authDataStorageImpl: AuthDataStorageImpl
    ): AuthDataStorage
}