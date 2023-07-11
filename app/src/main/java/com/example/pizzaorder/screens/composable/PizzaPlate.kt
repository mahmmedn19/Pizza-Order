/*
 * Created by Mohamed Naser on 7/10/23, 12:07 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.screens.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaHorizontalPager(
    images: List<Int>,
    pagerState: PagerState,
    pizzaSizeState: Float
) {
    HorizontalPager(
        pageCount = images.size,
        state = pagerState,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
        pageSpacing = 16.dp
    ) { page ->
        PizzaBox(
            image = images[page],
            scaleSize = pizzaSizeState
        )
    }
}

@Composable
fun PizzaBox(
    image: Int,
    scaleSize: Float
) {
    Box(
        modifier = Modifier
            .wrapContentSize(),
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .scale(scaleSize)
                .size(200.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
        )
    }
}