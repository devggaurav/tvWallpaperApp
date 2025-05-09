package com.gc.tvwallpapers.di

import com.gc.tvwallpapers.network.PixabayApiService
import com.gc.tvwallpapers.network.data.PixabayRepository
import com.gc.tvwallpapers.network.data.PixabayRepositoryImpl
import com.gc.tvwallpapers.network.usecase.SearchImagesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


//
// Created by Code For Android on 09/05/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pixabay.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePixabayApiService(retrofit: Retrofit): PixabayApiService {
        return retrofit.create(PixabayApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePixabayRepository(pixabayApiService: PixabayApiService): PixabayRepository {
        return PixabayRepositoryImpl(pixabayApiService)
    }


    @Provides
    @Singleton
    fun provideSearchUseCase(pixabayRepository: PixabayRepository): SearchImagesUseCase {
        return SearchImagesUseCase(pixabayRepository)
    }

}