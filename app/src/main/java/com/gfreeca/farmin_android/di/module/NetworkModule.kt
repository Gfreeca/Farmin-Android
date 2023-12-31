package com.gfreeca.farmin_android.di.module

import com.gfreeca.farmin_android.data.remote.network.AnnouncementAPI
import com.gfreeca.farmin_android.data.remote.network.ApplicationAPI
import com.gfreeca.farmin_android.data.remote.network.AuthAPI
import com.gfreeca.farmin_android.data.remote.network.LoginInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CookieJar
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkhttpClient(
        loginInterceptor: LoginInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .cookieJar(CookieJar.NO_COOKIES)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(loginInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BaseUrl.URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthAPI {
        return retrofit.create(AuthAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideAnnouncementService(retrofit: Retrofit): AnnouncementAPI {
        return retrofit.create(AnnouncementAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideApplicationService(retrofit: Retrofit): ApplicationAPI {
        return retrofit.create(ApplicationAPI::class.java)
    }
}