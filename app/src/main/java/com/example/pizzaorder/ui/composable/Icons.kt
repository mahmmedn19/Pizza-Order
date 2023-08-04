/*
 * Created by Mohamed Naser on 7/10/23, 9:50 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.ui.composable

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun CustomIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    drawableResId: Int,
    contentDescription: String? = null,
    tint: Color = Color.Black
) {
    IconButton(
        onClick = onClick
    ) {
        Icon(
            modifier = modifier,
            painter = painterResource(drawableResId),
            contentDescription = contentDescription,
            tint = tint
        )
    }
}