/*
 * Created by Mohamed Naser on 8/5/23, 4:30 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.data.source

import com.example.pizzaorder.R
import com.example.pizzaorder.ui.screens.Ingredient

object Data {

    val bread = listOf(
        BreadEntity(1, R.drawable.bread_1, 30),
        BreadEntity(2, R.drawable.bread_2, 20),
        BreadEntity(3, R.drawable.bread_3, 10),
        BreadEntity(4, R.drawable.bread_4, 35),
        BreadEntity(5, R.drawable.bread_5, 15),
    )

    val ingredients = listOf(
        Ingredient(1, "Basil", R.drawable.basil, R.drawable.group_basil, 15),
        Ingredient(2, "Onion", R.drawable.onion, R.drawable.group_onion, 10),
        Ingredient(3, "Broccoli", R.drawable.broccoli, R.drawable.group_broccoli, 8),
        Ingredient(4, "Mushroom", R.drawable.mushroom, R.drawable.group_mushroom, 7),
        Ingredient(5, "Sausage", R.drawable.sausage, R.drawable.group_sausage, 20)
    )
}