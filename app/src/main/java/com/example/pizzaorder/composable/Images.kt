/*
 * Created by Mohamed Naser on 7/10/23, 11:29 AM, 2023.
 *
 * Copyright (c) 2023 All rights reserved.
 */

package com.example.pizzaorder.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzaorder.R
import com.example.pizzaorder.ui.theme.Green

@Composable
fun ResizableImage(
    modifier: Modifier = Modifier,
    painter: Painter,
    size: Int = 0,
) {
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier
            .size(size.dp),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun IngredientList(
    ingredients: List<Int>,
    selectedIngredients: Set<Int>,
    onIngredientSelected: (Int) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)
    )  {
        items(ingredients.size) { index ->
            val ingredient = ingredients[index]
            val isSelected = ingredient in selectedIngredients
            Image(
                painter = painterResource(id = ingredient),
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        onIngredientSelected(ingredient)
                    }
                    .size(60.dp)
                    .background(
                        color = if (isSelected) Green else Color.Transparent,
                        shape = CircleShape
                    )
                    .padding(8.dp)
            )
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewScreenImage() {
    val imageList = listOf(
        R.drawable.basil,
        R.drawable.broccoli,
        R.drawable.onion,
        R.drawable.sausage,
        R.drawable.mushroom,
    )
    var selectedIngredients by remember { mutableStateOf<Set<Int>>(emptySet()) }

    IngredientList(
        ingredients = imageList,
        selectedIngredients = selectedIngredients,
        onIngredientSelected = { ingredient ->
            selectedIngredients = if (selectedIngredients.contains(ingredient)) {
                selectedIngredients.minus(ingredient)
            } else {
                selectedIngredients.plus(ingredient)
            }
        }
    )
}


