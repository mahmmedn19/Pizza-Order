/*
 * Created by Mohamed Naser on 7/10/23, 12:13 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.composable

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
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
    Button(
        modifier = modifier.shadow(1.dp, CircleShape),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(100.dp),
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = Typography.labelLarge
        )
    }
}
