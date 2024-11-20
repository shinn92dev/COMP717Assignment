package com.bcit.currencyapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Favorite(navController: NavController) {
    Text(
        "Favorite",
        fontSize = 50.sp,
        modifier = Modifier.padding(80.dp)
    )
}