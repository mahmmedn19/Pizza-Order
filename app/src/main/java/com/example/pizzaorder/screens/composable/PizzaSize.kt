/*
 * Created by Mohamed Naser on 7/10/23, 12:48 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.screens.composable

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzaorder.composable.TextButton
import com.example.pizzaorder.screens.PizzaSizeState

@Composable
fun PizzaSize(
    onClickS: () -> Unit,
    onClickM: () -> Unit,
    onClickL: () -> Unit,
    state: PizzaSizeState
) {
    val selectedButton = remember { mutableStateOf(state) }

/*    val transition = updateTransition(selectedButton.value, label = "")

    val boxOffsetY by transition.animateFloat(label = "") { buttonType ->
        run {
            val buttonIndex = when (buttonType) {
                PizzaSizeState.S -> 0
                PizzaSizeState.M -> 1
                PizzaSizeState.L -> 2
            }
            (buttonIndex * 60).toFloat()
        }
    }*/

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
/*        Box(
            modifier = Modifier
                .offset(x = (boxOffsetY).dp)
                .size(40.dp)
                .shadow(4.dp, CircleShape)
        )*/
        TextButton(
            modifier = Modifier.padding(end = 8.dp),
            onClick = {
                onClickS()
                selectedButton.value = PizzaSizeState.S
            },
            text = "S"
        )
        TextButton(
            modifier = Modifier.padding(end = 8.dp),
            onClick = {
                onClickM()
                selectedButton.value = PizzaSizeState.M
            },
            text = "M"
        )
        TextButton(
            onClick = {
                onClickL()
                selectedButton.value = PizzaSizeState.L
            },
            text = "L"
        )
    }

}