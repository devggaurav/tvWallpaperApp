package com.gc.tvwallpapers.network.data

import com.gc.tvwallpapers.network.Resource
import kotlinx.coroutines.flow.Flow


//
// Created by Code For Android on 05/05/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

interface PixabayRepository {
    fun searchImages(query: String): Flow<Resource<PixabayResponse>>
}