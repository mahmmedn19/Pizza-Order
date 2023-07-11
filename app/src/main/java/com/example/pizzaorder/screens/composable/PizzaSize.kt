/*
 * Created by Mohamed Naser on 7/10/23, 12:48 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.screens.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pizzaorder.composable.TextButton
@Composable
fun PizzaSize(
    onClickS: () -> Unit,
    onClickM: () -> Unit,
    onClickL: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
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