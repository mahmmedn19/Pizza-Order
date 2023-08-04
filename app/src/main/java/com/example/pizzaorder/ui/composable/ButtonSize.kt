/*
 * Created by Mohamed Naser on 7/10/23, 12:13 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pizzaorder.ui.theme.Typography

@Composable
fun TextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String
) {
    val interactionSource = remember { MutableInteractionSource() }

    Text(
        modifier = modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onClick()
            }
            .size(48.dp)
            .wrapContentHeight(),
        text = text,
        textAlign = TextAlign.Center,
        style = Typography.labelLarge,
    )
}

