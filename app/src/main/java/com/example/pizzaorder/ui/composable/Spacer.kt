/*
 * Created by Mohamed Naser on 7/11/23, 1:15 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.ui.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun VerticalSpacer(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun HorizontalSpacer(width: Dp) {
    Spacer(modifier = Modifier.width(width))
}