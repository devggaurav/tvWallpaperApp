package com.gc.tvwallpapers.network.data

import com.google.gson.annotations.SerializedName


//
// Created by Code For Android on 05/05/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

data class PixabayImage(
    @SerializedName("id")
    val id: Int,
    @SerializedName("pageURL")
    val pageURL: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("tags")
    val tags: String,
    @SerializedName("previewURL")
    val previewURL: String,
    @SerializedName("largeImageURL")
    val largeImageURL: String,
    @SerializedName("views")
    val views: Int,
    @SerializedName("downloads")
    val downloads: Int,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("comments")
    val comments: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user")
    val user: String
)
