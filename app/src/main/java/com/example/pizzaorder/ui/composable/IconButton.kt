/*
 * Created by Mohamed Naser on 8/4/23, 5:51 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.ui.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaorder.ui.theme.Brown

@Composable
fun IconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    drawableResId: Int,
    contentDescription: String? = null,
    text: String,
    textColor: Color = Color.White,
    tint: Color = Color.White
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Transparent,
            containerColor = Brown
        ),
        contentPadding = PaddingValues(8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val painter = painterResource(drawableResId)
            Icon(
                painter = painter,
                contentDescription = contentDescription,
                tint = tint
            )
            HorizontalSpacer(width = 4.dp)
            Text(
                text = text,
                color = textColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}