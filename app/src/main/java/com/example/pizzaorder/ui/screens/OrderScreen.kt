/*
 * Created by Mohamed Naser on 8/6/23, 4:52 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaorder.R
import com.example.pizzaorder.ui.composable.VerticalSpacer

@Composable
fun OrderScreen() {
    Column (
        modifier =  Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //todo save color in Colors Files
        val color = Color(0xFF007500)
        Text(
            text = "Pizza delivered",
            fontSize = 30.sp,
            color = color,
            fontWeight = FontWeight.Bold
        )

        VerticalSpacer(height = 20.dp)

        Icon(modifier = Modifier.size(80.dp),
            painter = painterResource(
            id = R.drawable.ic_baseline_check_circle_outline_24),
            contentDescription = "Pizza delivered",
            tint = color
        )
    }
}

@Composable
@Preview(showBackground = true)
fun OrderScreenPreview() {
    OrderScreen()
}