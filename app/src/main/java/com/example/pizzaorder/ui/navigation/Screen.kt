/*
 * Created by Mohamed Naser on 8/6/23, 4:49 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.ui.navigation

sealed class Screen(val rout: String) {
    object PizzaScreen: Screen("pizza-screen-rout")
    object OrderScreen: Screen("order-screen-rout")
}
