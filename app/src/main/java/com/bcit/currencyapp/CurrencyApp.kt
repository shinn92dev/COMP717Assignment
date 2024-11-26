package com.bcit.currencyapp

import android.util.Log
import com.bcit.currencyapp.api.CurrencyViewModel
import androidx.activity.ComponentActivity
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.bcit.currencyapp.component.BottomBar
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.composable

@Composable
fun CurrencyApp() {
    val navController = rememberNavController()
    val activity = LocalContext.current as ComponentActivity
    val viewModel = ViewModelProvider(activity).get(CurrencyViewModel::class.java)
    val currencyData by viewModel.currencyData.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCurrencyData("eur")
    }
    val startDestination = if (currencyData == null) "loading" else "home"
    Log.d("HEREHEHERE", "$currencyData")

    Scaffold(
        bottomBar = { BottomBar(navController)}
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(padding)
        ) {
            composable("home") {
                Home(navController)
            }
            composable("loading") {
                Loading(navController)
            }
            composable("favorite") {
                Favorite(navController)
            }
        }
    }
    LaunchedEffect(currencyData) {
        if (currencyData != null) {
            navController.navigate("home") {
                popUpTo("loading") { inclusive = true }
            }
        }
    }
}