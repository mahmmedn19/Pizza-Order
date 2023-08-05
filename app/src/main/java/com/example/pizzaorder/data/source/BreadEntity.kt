/*
 * Created by Mohamed Naser on 8/5/23, 4:33 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.data.source

import com.example.pizzaorder.ui.screens.Bread
import com.example.pizzaorder.ui.screens.Ingredient

data class BreadEntity (
    val id: Int,
    val imageId: Int,
    val price: Int
) {
    fun toBread(ingredients: List<Ingredient> = Data.ingredients)
    = Bread(
        id = id,
        image = imageId,
        price = price,
        ingredients = ingredients
    )
}