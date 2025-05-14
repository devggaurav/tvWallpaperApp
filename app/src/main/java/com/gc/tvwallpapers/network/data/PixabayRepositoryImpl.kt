package com.gc.tvwallpapers.network.data

import com.gc.tvwallpapers.network.PixabayApiService
import com.gc.tvwallpapers.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


//
// Created by Code For Android on 05/05/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

class PixabayRepositoryImpl @Inject constructor(
    private val pixabayApiService: PixabayApiService
) : PixabayRepository {

    override fun searchImages(query: String): Flow<Resource<PixabayResponse>> = flow {
        try {
            emit(Resource.Loading)

            val response = pixabayApiService.searchImages(
                apiKey = "-4b2f7f9bd1ac7ce7067f5b354",  //Test api key
                query = query
            )

            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.Success(it))
                } ?: emit(Resource.Error("Empty response body"))
            } else {
                emit(Resource.Error("Error: ${response.code()} - ${response.message()}"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error("Network error: ${e.message ?: "Unknown HTTP error"}"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        } catch (e: Exception) {
            emit(Resource.Error("Unexpected error: ${e.message ?: "Unknown error"}"))
        }
    }
}