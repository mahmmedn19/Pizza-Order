/*
 * Created by Mohamed Naser on 7/10/23, 9:46 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzaorder.R
import com.example.pizzaorder.composable.IngredientList
import com.example.pizzaorder.composable.ResizableImage
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
    var selectedIngredient by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
/*        AppBar(
            {*//*TODO*//* },
            {*//*TODO*//* }
        )*/
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
            PizzaHorizontalPager(imageList, pagerState = pagerState)
        }
        Text(
            text = "$ 17",
            modifier = Modifier.fillMaxWidth().padding(
                bottom = 16.dp
            ),
            textAlign = TextAlign.Center,
            style = Typography.titleLarge
        )
        PizzaSize()
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
            onIngredientSelected = { ingredient ->
                selectedIngredient = ingredient
            },
            selectedIngredient = selectedIngredient
        )

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewScreen() {
    PizzaScreen()
}


