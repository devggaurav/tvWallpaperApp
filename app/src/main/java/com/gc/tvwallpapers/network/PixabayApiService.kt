package com.gc.tvwallpapers.network

import com.gc.tvwallpapers.network.data.PixabayResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


//
// Created by Code For Android on 05/05/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

interface PixabayApiService {
    @GET("/api/")
    suspend fun searchImages(
        @Query("key") apiKey: String,
        @Query("q") query: String,
        @Query("image_type") imageType: String = "photo",
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): Response<PixabayResponse>
}