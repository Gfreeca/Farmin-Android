package com.gfreeca.farmin_android.di.module

import com.gfreeca.farmin_android.data.repository.AnnouncementRepositoryImpl
import com.gfreeca.farmin_android.data.repository.AuthRepositoryImpl
import com.gfreeca.farmin_android.domain.repository.AnnouncementRepository
import com.gfreeca.farmin_android.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    abstract fun provideAnnouncementRepository(
        announcementRepositoryImpl: AnnouncementRepositoryImpl
    ): AnnouncementRepository
}