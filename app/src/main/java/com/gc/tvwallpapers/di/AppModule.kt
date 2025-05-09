package com.gc.tvwallpapers.di

import com.gc.tvwallpapers.network.PixabayApiService
import com.gc.tvwallpapers.network.data.PixabayRepository
import com.gc.tvwallpapers.network.data.PixabayRepositoryImpl
import com.gc.tvwallpapers.network.usecase.SearchImagesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


//
// Created by Code For Android on 09/05/25.
// Copyright (c) 2025 CFA. All rights reserved.
//


