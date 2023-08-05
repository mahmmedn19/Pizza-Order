/*
 * Created by Mohamed Naser on 8/4/23, 5:50 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import com.google.accompanist.pager.ExperimentalPagerApi

data class PizzaUiState @OptIn(ExperimentalFoundationApi::class) constructor(
    val id: Int = 0,
    val breads: List<Bread> = emptyList(),
    val pizzaSizeState: PizzaSizeState = PizzaSizeState.M,
    val price: Int = 0,
    val pagerState: PagerState = PagerState()
    )
data class Bread(
    val id: Int = 0,
    val image: Int = 0,
    val price: Int = 0,
    val ingredients: List<Ingredient> = emptyList(),
)
data class Ingredient(
    val id: Int,
    val name: String = "",
    val mainImage: Int = 0,
    val image: Int = 0,
    val price: Int = 0,
    var isSelected: Boolean = false
)

sealed class PizzaSizeState(val priceForSize: Int) {
    object S : PizzaSizeState(10)
    object M : PizzaSizeState(15)
    object L : PizzaSizeState(20)
}
