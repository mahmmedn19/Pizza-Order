/*
 * Created by Mohamed Naser on 8/4/23, 5:50 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.ui.screens
data class PizzaUiState(
    val id: Int = 0,
    val breads: List<Bread> = emptyList(),
    val pizzaSizeState: PizzaSizeState = PizzaSizeState.M,
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
    var isSelected: Boolean = false,
)

sealed class PizzaSizeState {
    object S : PizzaSizeState()
    object M : PizzaSizeState()
    object L : PizzaSizeState()
}
