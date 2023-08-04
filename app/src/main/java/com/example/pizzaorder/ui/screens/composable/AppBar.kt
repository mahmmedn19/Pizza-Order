/*
 * Created by Mohamed Naser on 8/4/23, 5:51 PM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.ui.screens.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.pizzaorder.R
import com.example.pizzaorder.ui.composable.CustomIconButton
import com.example.pizzaorder.ui.theme.Typography

@Composable
fun AppBar(
    onClickBack: () -> Unit,
    onClickFav: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CustomIconButton(
            onClick = { onClickBack() },
            drawableResId = R.drawable.ic_back
        )
        Text(
            text = stringResource(R.string.pizza),
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            style = Typography.titleLarge
        )
        CustomIconButton(
            onClick = { onClickFav() },
            drawableResId = R.drawable.ic_favorite
        )
    }
}