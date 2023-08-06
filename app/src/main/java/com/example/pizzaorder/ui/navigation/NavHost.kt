/*
 * Created by Mohamed Naser on 8/6/23, 4:38 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pizzaorder.ui.screens.OrderScreen
import com.example.pizzaorder.ui.screens.PizzaScreen

@Composable
fun NavHostController(
    navController: NavHostController,
    startDestinationRout: String = Screen.PizzaScreen.rout
    ) {
    NavHost(
        navController = navController,
        startDestination = startDestinationRout
    ) {
        composable(route = Screen.PizzaScreen.rout) { PizzaScreen(navController)}

        composable(route = Screen.OrderScreen.rout) { OrderScreen() }
    }
}