package com.gc.tvwallpapers.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gc.tvwallpapers.network.Resource
import com.gc.tvwallpapers.network.data.PixabayImage
import com.gc.tvwallpapers.network.data.PixabayRepository
import com.gc.tvwallpapers.network.usecase.SearchImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


//
// Created by Code For Android on 09/05/25.
// Copyright (c) 2025 CFA. All rights reserved.
//

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PixabayRepository
) : ViewModel() {

    private val _searchState = MutableStateFlow<SearchState>(SearchState.Initial)
    val searchState: StateFlow<SearchState> = _searchState

    private val _searchQuery = MutableStateFlow("yellow flowers")
    val searchQuery: StateFlow<String> = _searchQuery

    init {
        searchImages(_searchQuery.value)
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun searchImages(query: String = _searchQuery.value) {
        viewModelScope.launch {
            repository.searchImages(query).onEach { result ->
                _searchState.value = when (result) {
                    is Resource.Loading -> SearchState.Loading
                    is Resource.Success -> SearchState.Success(result.data.images)
                    is Resource.Error -> SearchState.Error(result.message)
                }
            }.launchIn(viewModelScope)
        }
    }

    sealed class SearchState {
        object Initial : SearchState()
        object Loading : SearchState()
        data class Success(val images: List<PixabayImage>) : SearchState()
        data class Error(val message: String) : SearchState()
    }
}