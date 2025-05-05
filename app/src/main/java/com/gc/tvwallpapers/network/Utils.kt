package com.gc.tvwallpapers.network


//
// Created by Code For Android on 05/05/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val message: String) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}