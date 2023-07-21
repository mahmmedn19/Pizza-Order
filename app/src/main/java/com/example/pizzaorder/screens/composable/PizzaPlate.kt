/*
 * Created by Mohamed Naser on 7/10/23, 12:07 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.screens.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.example.pizzaorder.screens.Bread

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaHorizontalPager(
    images: List<Bread>,
    pagerState: PagerState,
    pizzaSizeState: Float,
) {
    Column {
        HorizontalPager(
            pageCount = images.size,
            state = pagerState,
            modifier = Modifier.height(250.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
            pageSpacing = 16.dp
        ) { page ->
            Box(
                modifier = Modifier
                    .scale(pizzaSizeState)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(images[page].image)
                        .crossfade(true)
                        .scale(Scale.FILL)
                        .build(),
                    contentDescription = "Bread",
                )

                images[page].ingredients.forEach { ingredients ->
                    IngredientsItem(
                        image = ingredients.image,
                        isSelected = ingredients.isSelected,
                        modifier = Modifier
                            .size(120.dp)
                            .padding(pizzaSizeState.dp)
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun IngredientsItem(
    image: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    AnimatedVisibility(
        visible = isSelected,
        enter = scaleIn(initialScale = 10f) + fadeIn(),
        exit = fadeOut(),
    ) {
        Image(
            modifier = modifier,
            painter = painterResource(id = image),
            contentDescription = "Bread"
        )
    }
}