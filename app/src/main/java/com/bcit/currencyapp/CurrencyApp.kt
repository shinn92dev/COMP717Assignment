package com.bcit.currencyapp

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.bcit.currencyapp.component.BottomBar
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.composable

@Composable
fun CurrencyApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController)}
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") {
                Home(navController)
            }
            composable("favorite") {
                Favorite(navController)
            }
        }
    }
}