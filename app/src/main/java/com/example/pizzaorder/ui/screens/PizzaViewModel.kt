/*
 * Created by Mohamed Naser on 8/4/23, 5:50 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.ui.screens

import androidx.lifecycle.ViewModel
import com.example.pizzaorder.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(PizzaUiState())
    val uiState = _uiState.asStateFlow()
    init {
        _uiState.update {
            it.copy(
                breads = getBread(),
            )
        }
    }
    fun getIngredientsSelection(ingredientIndex: Int, breadIndex: Int) {
        _uiState.update {
            val breads = it.breads.toMutableList()
            val bread = breads[breadIndex]
            val ingredients = bread.ingredients.toMutableList()
            val ingredient = ingredients[ingredientIndex]
            ingredients[ingredientIndex] = ingredient.copy(
                isSelected = !ingredient.isSelected,
            )
            breads[breadIndex] = bread.copy(
                ingredients = ingredients,
            )
            it.copy(
                breads = breads,
            )
        }
    }

    private fun getBread(): List<Bread> {
        return listOf(
            Bread(1, R.drawable.bread_1, 30,  getIngredients()),
            Bread(2, R.drawable.bread_2, 27,  getIngredients()),
            Bread(3, R.drawable.bread_3, 34,  getIngredients()),
            Bread(4, R.drawable.bread_4, 53,   getIngredients()),
            Bread(5, R.drawable.bread_5, 32,   getIngredients()),
        )
    }


    private fun getIngredients(): List<Ingredient> {
        return listOf(
            Ingredient(1, "Basil", R.drawable.basil, R.drawable.group_basil),
            Ingredient(2, "Onion", R.drawable.onion, R.drawable.group_onion),
            Ingredient(3, "Broccoli", R.drawable.broccoli, R.drawable.group_broccoli),
            Ingredient(4, "Mushroom", R.drawable.mushroom, R.drawable.group_mushroom),
            Ingredient(5, "Sausage", R.drawable.sausage, R.drawable.group_sausage),
        )
    }






    fun onPizzaSizeSelected(size: PizzaSizeState) {
        _uiState.value = _uiState.value.copy(pizzaSizeState = size)
    }
}