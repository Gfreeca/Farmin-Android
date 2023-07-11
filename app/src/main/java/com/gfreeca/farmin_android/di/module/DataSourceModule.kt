package com.gfreeca.farmin_android.di.module

import com.gfreeca.farmin_android.data.local.datasource.auth.LocalAuthDataSource
import com.gfreeca.farmin_android.data.local.datasource.auth.LocalAuthDataSourceImpl
import com.gfreeca.farmin_android.data.remote.datasource.announcement.AnnouncementDataSource
import com.gfreeca.farmin_android.data.remote.datasource.announcement.AnnouncementDataSourceImpl
import com.gfreeca.farmin_android.data.remote.datasource.announcement.ApplicationDataSource
import com.gfreeca.farmin_android.data.remote.datasource.announcement.ApplicationDataSourceImpl
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
        authDataSourceImpl: AuthDataSourceImpl
    ): AuthDataSource

    @Binds
    abstract fun provideLocalDataSource(
        localAuthDataSourceImpl: LocalAuthDataSourceImpl
    ): LocalAuthDataSource

    @Binds
    abstract fun provideAnnouncementDataSource(
        announcementDataSourceImpl: AnnouncementDataSourceImpl
    ): AnnouncementDataSource

    @Binds
    abstract fun provideApplicationDataSource(
        applicationDataSourceImpl: ApplicationDataSourceImpl
    ): ApplicationDataSource
}