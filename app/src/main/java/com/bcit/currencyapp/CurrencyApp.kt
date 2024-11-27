package com.bcit.currencyapp

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
import com.bcit.currencyapp.component.TopBar
import com.bcit.currencyapp.pages.*

@Composable
fun CurrencyApp() {
    val navController = rememberNavController()
    val activity = LocalContext.current as ComponentActivity
    val viewModel = ViewModelProvider(activity)[CurrencyViewModel::class.java]
    val currencyData by viewModel.currencyData.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchAllCurrencyData()
    }
    val cad = currencyData?.cad?.get("cad") as? Map<*, *>
    val usd = currencyData?.usd?.get("usd") as? Map<*, *>
    val eur = currencyData?.eur?.get("eur") as? Map<*, *>
    val krw = currencyData?.krw?.get("krw") as? Map<*, *>
    val jpy = currencyData?.jpy?.get("jpy") as? Map<*, *>

    val startDestination = if (currencyData == null) "loading" else "cad"

    Scaffold(
        topBar = { TopBar(navController)},
        bottomBar = { BottomBar(navController)},
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(padding)
        ) {
            composable("cad") {
                if (cad != null) {
                    CAD(cad)
                }
            }
            composable("usd") {
                if (usd != null) {
                    USD(usd)
                }
            }
            composable("krw") {
                if (krw != null) {
                    KRW(krw)
                }
            }
            composable("jpy") {
                if (jpy != null) {
                    JPY(jpy)
                }
            }
            composable("eur") {
                if (eur != null) {
                    EUR(eur)
                }
            }
            composable("loading") {
                Loading()
            }
            composable("about") {
                About()
            }

        }
    }
    LaunchedEffect(currencyData) {
        if (currencyData != null) {
            navController.navigate("cad") {
                popUpTo("loading") { inclusive = true }
            }
        }
    }
}