/*
 * Created by Mohamed Naser on 8/4/23, 5:50 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.ui.screens.composable

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pizzaorder.ui.composable.TextButton
import com.example.pizzaorder.ui.screens.PizzaSizeState

@Composable
fun PizzaSize(
    onClickS: () -> Unit,
    onClickM: () -> Unit,
    onClickL: () -> Unit,
    state: PizzaSizeState,
    modifier: Modifier = Modifier,
) {

    val position by animateDpAsState(
        targetValue = when (state) {
            PizzaSizeState.S -> 0.dp
            PizzaSizeState.M -> 57.dp
            PizzaSizeState.L -> 112.dp
        }, label = "size Animation",
        animationSpec = tween(
            durationMillis = 300,
            easing = LinearOutSlowInEasing
        )
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = modifier
                .matchParentSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Card(
                modifier = Modifier
                    .size(45.dp)
                    .offset(x = position, y = 0.dp),
                shape = CircleShape,
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp,
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
            ) {

            }
        }
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
        ) {
            TextButton(
                modifier = Modifier.padding(end = 8.dp),
                onClick = {
                    onClickS()
                },
                text = "S"
            )
            TextButton(
                modifier = Modifier.padding(end = 8.dp),
                onClick = {
                    onClickM()
                },
                text = "M"
            )
            TextButton(
                onClick = {
                    onClickL()
                },
                text = "L"
            )
        }
    }
}