package com.gc.tvwallpapers.presentation.screens


//
// Created by Code For Android on 12/05/25.
// Copyright (c) 2025 CFA. All rights reserved.
//


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Card
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gc.tvwallpapers.network.data.PixabayImage

@Composable
fun ImageCard(
    image: PixabayImage,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = {}
    ) {
        Column {
            // Image
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(image.largeImageURL)
                    .crossfade(true)
                    .placeholder(com.gc.tvwallpapers.R.drawable)
                    .error(R.drawable.error_image)
                    .build(),
                contentDescription = "Image by ${image.user}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            // Content
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = image.user,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${image.likes} likes",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = image.tags,
                        style = MaterialTheme.typography.bodySmall,
                        fontStyle = FontStyle.Italic,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}