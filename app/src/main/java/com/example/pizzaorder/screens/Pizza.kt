/*
 * Created by Mohamed Naser on 7/10/23, 9:46 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.screens

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
import com.airbnb.lottie.compose.*
import com.example.pizzaorder.R
import com.example.pizzaorder.composable.IconButton
import com.example.pizzaorder.composable.IngredientList
import com.example.pizzaorder.composable.ResizableImage
import com.example.pizzaorder.screens.composable.AppBar
import com.example.pizzaorder.screens.composable.PizzaHorizontalPager
import com.example.pizzaorder.screens.composable.PizzaSize
import com.example.pizzaorder.ui.theme.Typography

@Composable
fun PizzaScreen() {
    val viewModel: PizzaViewModel = hiltViewModel()

    val state by viewModel.uiState.collectAsState()


    PizzaContent(
        state = state,
        onIngredientSelected = viewModel::getIngredientsSelection,
        onPizzaSizeSelected = viewModel::onPizzaSizeSelected
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaContent(
    state: PizzaUiState,
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
        AppBar(
            {/*TODO*/ },
            {/*TODO*/ }
        )
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
                pagerState = pagerState,
                pizzaSizeState = imageSize,
            )
        }
        Text(
            text = "$ 17",
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
            ingredients = state.breads[pagerState.currentPage].ingredients,
            onIngredientSelected = { index ->
                onIngredientSelected(index, pagerState.currentPage)
            }
        )

        IconButton(
            modifier = Modifier.padding(top = 16.dp),
            onClick = { /*TODO*/ },
            drawableResId = R.drawable.ic_cart,
            text = stringResource(
                R.string.add_to_cart
            )
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewScreen() {
    PizzaScreen()
}