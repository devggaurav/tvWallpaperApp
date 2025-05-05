package com.gc.tvwallpapers.network.data

import com.google.gson.annotations.SerializedName


//
// Created by Code For Android on 05/05/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

data class PixabayResponse(
    @SerializedName("total")
    val total: Int,
    @SerializedName("totalHits")
    val totalHits: Int,
    @SerializedName("hits")
    val images: List<PixabayImage>
)