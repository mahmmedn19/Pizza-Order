/*
 * Created by Mohamed Naser on 7/11/23, 5:35 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.screens

sealed class PizzaSizeState {
    object S : PizzaSizeState()
    object M : PizzaSizeState()
    object L : PizzaSizeState()
}
