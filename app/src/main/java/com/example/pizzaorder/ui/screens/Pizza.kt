/*
 * Created by Mohamed Naser on 8/4/23, 5:50 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.*
import com.example.pizzaorder.R
import com.example.pizzaorder.ui.composable.IconButton
import com.example.pizzaorder.ui.composable.IngredientList
import com.example.pizzaorder.ui.composable.ResizableImage
import com.example.pizzaorder.ui.navigation.Screen
import com.example.pizzaorder.ui.screens.composable.AppBar
import com.example.pizzaorder.ui.screens.composable.PizzaHorizontalPager
import com.example.pizzaorder.ui.screens.composable.PizzaSize
import com.example.pizzaorder.ui.theme.Typography

@Composable
fun PizzaScreen(
    navHostController: NavHostController
) {
    val viewModel: PizzaViewModel = hiltViewModel()

    val state by viewModel.uiState.collectAsState()


    PizzaContent(
        state = state,
        navHostController,
        onIngredientSelected = viewModel::getIngredientsSelection,
        onPizzaSizeSelected = viewModel::onPizzaSizeSelected
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaContent(
    state: PizzaUiState,
    navHostController: NavHostController,
    onIngredientSelected: (Int, Int) -> Unit,
    onPizzaSizeSelected: (PizzaSizeState) -> Unit
) {
    val pagerState = rememberPagerState(0)
    val imageSize by animateFloatAsState(
        targetValue = when (state.pizzaSizeState) {
            PizzaSizeState.S -> 1f
            PizzaSizeState.M -> 1.2f
            PizzaSizeState.L -> 1.4f
        },
        animationSpec = tween(durationMillis = 300, easing = EaseOutSine)
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            ResizableImage(
                painter = painterResource(id = R.drawable.plate),
                size = 250
            )
            PizzaHorizontalPager(
                images = state.breads,
                pagerState = state.pagerState,
                pizzaSizeState = imageSize,
            )
        }
        Text(
            text = "${state.price} $",
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 16.dp
                ),
            textAlign = TextAlign.Center,
            style = Typography.titleLarge
        )
        PizzaSize(
            onClickS = { onPizzaSizeSelected(PizzaSizeState.S) },
            onClickM = { onPizzaSizeSelected(PizzaSizeState.M) },
            onClickL = { onPizzaSizeSelected(PizzaSizeState.L) },
            state = state.pizzaSizeState
        )
        Text(
            text = "CUSTOMIZE YOUR PIZZA",
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    top = 32.dp,
                    bottom = 32.dp
                ),
            textAlign = TextAlign.Start,
            style = Typography.labelSmall
        )

        IngredientList(
            ingredients = state.breads[state.pagerState.currentPage].ingredients,
            onIngredientSelected = { index ->
                onIngredientSelected(index, state.pagerState.currentPage)
            }
        )

        IconButton(
            modifier = Modifier.padding(top = 16.dp),
            onClick = {
                      navHostController.navigate(Screen.OrderScreen.rout)
            },
            drawableResId = R.drawable.ic_cart,
            text = stringResource(
                R.string.order_Pizza
            )
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewScreen() {
    PizzaScreen(rememberNavController())
}