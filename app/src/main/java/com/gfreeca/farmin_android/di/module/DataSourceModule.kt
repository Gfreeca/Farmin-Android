package com.gfreeca.farmin_android.di.module

import com.gfreeca.farmin_android.data.local.datasource.auth.LocalAuthDataSource
import com.gfreeca.farmin_android.data.local.datasource.auth.LocalAuthDataSourceImpl
import com.gfreeca.farmin_android.data.remote.datasource.auth.AuthDataSource
import com.gfreeca.farmin_android.data.remote.datasource.auth.AuthDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun provideAuthDataSource(
        authDataSourceImpl: AuthDataSourceImpl,
    ): AuthDataSource

    @Binds
    abstract fun provideLocalDataSource(
        localAuthDataSourceImpl: LocalAuthDataSourceImpl
    ): LocalAuthDataSource
}