/*
 * Created by Mohamed Naser on 8/4/23, 5:50 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.lifecycle.ViewModel
import com.example.pizzaorder.data.source.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@OptIn(ExperimentalFoundationApi::class)
@HiltViewModel
class PizzaViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(PizzaUiState())
    val uiState = _uiState.asStateFlow()
    init {
        _uiState.update {
            val breads = getBread()
            it.copy(
                breads = breads,
                price = breads[it.pagerState.currentPage].price + it.pizzaSizeState.priceForSize
            )
        }
    }
    fun getIngredientsSelection(ingredientIndex: Int, breadIndex: Int) {
        _uiState.update { it ->
            val breads = it.breads.toMutableList()
            val bread = breads[breadIndex]
            val ingredients = bread.ingredients.toMutableList()
            val ingredient = ingredients[ingredientIndex]

            ingredients[ingredientIndex] = ingredient.copy(
                isSelected = !ingredient.isSelected,
            )
            breads[breadIndex] = bread.copy(
                ingredients = ingredients
            )

            var price = breads[breadIndex].price + it.pizzaSizeState.priceForSize

            ingredients.filter {
                it.isSelected
            }.forEach { ing ->
                Log.d("ViewModelTag", "selected ing: $ing")
                price += ing.price
            }
            it.copy(
                breads = breads,
                price = price
            )
        }
    }

    private fun getBread(): List<Bread> = Data.bread.map { it.toBread() }

    fun onPizzaSizeSelected(size: PizzaSizeState) {
        _uiState.update {
            val price = it.price - it.pizzaSizeState.priceForSize + size.priceForSize

            it.copy(
                pizzaSizeState = size,
                price = price
            )
        }

        _uiState.value = _uiState.value.copy(pizzaSizeState = size)
    }
}