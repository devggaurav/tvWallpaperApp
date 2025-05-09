package com.gc.tvwallpapers.network.usecase

import com.gc.tvwallpapers.network.Resource
import com.gc.tvwallpapers.network.data.PixabayRepository
import com.gc.tvwallpapers.network.data.PixabayResponse
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow


//
// Created by Code For Android on 09/05/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

class SearchImagesUseCase @Inject constructor(
    private val repository: PixabayRepository
) {
    operator fun invoke(query: String): Flow<Resource<PixabayResponse>> {
        return repository.searchImages(query)
    }
}