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
import com.example.pizzaorder.R
import com.example.pizzaorder.composable.IconButton
import com.example.pizzaorder.composable.IngredientList
import com.example.pizzaorder.composable.ResizableImage
import com.example.pizzaorder.screens.composable.AppBar
import com.example.pizzaorder.screens.composable.PizzaHorizontalPager
import com.example.pizzaorder.screens.composable.PizzaSize
import com.example.pizzaorder.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaScreen() {
    val imageList = listOf(
        R.drawable.bread_1,
        R.drawable.bread_2,
        R.drawable.bread_3,
        R.drawable.bread_4,
        R.drawable.bread_5,
    )
    val imageListIngredient = listOf(
        R.drawable.basil,
        R.drawable.broccoli,
        R.drawable.onion,
        R.drawable.sausage,
        R.drawable.mushroom,
    )
    val pagerState = rememberPagerState(0)
    var selectedIngredientsMap by remember { mutableStateOf<Map<Int, Set<Int>>>(emptyMap()) }

    // this im set when add ingredients
    var pizzaSizeState by remember { mutableStateOf<PizzaSizeState>(PizzaSizeState.M) }

    val imageSize by animateFloatAsState(
        targetValue = when (pizzaSizeState) {
            PizzaSizeState.S -> 0.7f
            PizzaSizeState.M -> 0.9f
            PizzaSizeState.L -> 1.1f
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
                images = imageList,
                pagerState = pagerState,
                pizzaSizeState = imageSize,
                selectedIngredientsMap = selectedIngredientsMap,
                onIngredientSelected = { pizzaIndex, ingredient ->
                    val currentIngredients =
                        selectedIngredientsMap.getOrElse(pizzaIndex) { emptySet() }
                    val updatedIngredients = if (currentIngredients.contains(ingredient)) {
                        currentIngredients.minus(ingredient)
                    } else {
                        currentIngredients.plus(ingredient)
                    }
                    selectedIngredientsMap =
                        selectedIngredientsMap + (pizzaIndex to updatedIngredients)
                }
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
            onClickS = { pizzaSizeState = PizzaSizeState.S },
            onClickM = { pizzaSizeState = PizzaSizeState.M },
            onClickL = { pizzaSizeState = PizzaSizeState.L },
            state = pizzaSizeState
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
            ingredients = imageListIngredient,
            selectedIngredients = selectedIngredientsMap.getOrElse(pagerState.currentPage) { emptySet() },
            onIngredientSelected = { ingredient ->
                val currentPage = pagerState.currentPage
                val currentIngredients =
                    selectedIngredientsMap.getOrElse(currentPage) { emptySet() }
                val updatedIngredients = if (currentIngredients.contains(ingredient)) {
                    currentIngredients.minus(ingredient)
                } else {
                    currentIngredients.plus(ingredient)
                }
                selectedIngredientsMap =
                    selectedIngredientsMap + (currentPage to updatedIngredients)
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