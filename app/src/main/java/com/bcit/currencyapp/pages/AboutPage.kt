package com.bcit.currencyapp.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcit.currencyapp.R
import com.bcit.currencyapp.component.BaseCurrencyItem
import com.bcit.currencyapp.component.CurrencyGridItem

@Composable
fun AboutPage() {
    val majorCurrencies = mapOf(
        "cad" to "Canadian Dollar",
        "usd" to "United States Dollar",
        "krw" to "South Korean Won",
        "jpy" to "Japanese Yen",
        "eur" to "Euro",
        "gbp" to "British Pound Sterling",
        "aud" to "Australian Dollar",
        "cny" to "Chinese Yuan",
        "chf" to "Swiss Franc",
        "hkd" to "Hong Kong Dollar",
        "inr" to "Indian Rupee",
        "sgd" to "Singapore Dollar",
        "brl" to "Brazilian Real",
        "zar" to "South African Rand",
        "mxn" to "Mexican Peso",
        "rub" to "Russian Ruble",
        "aed" to "United Arab Emirates Dirham",
        "sek" to "Swedish Krona",
        "nzd" to "New Zealand Dollar",
        "try" to "Turkish Lira"
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "About ExchangeMate",
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6200EA)
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "ExchangeMate is a simple and powerful currency exchange app. " +
                    "It allows you to view exchange rates for major currencies and easily " +
                    "compare them with 20 popular currencies worldwide.",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Supported Base Currencies:",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            BaseCurrencyItem(R.drawable.cad, "CAD", "Canadian Dollar")
            BaseCurrencyItem(R.drawable.usd, "USD", "United States Dollar")
            BaseCurrencyItem(R.drawable.krw, "KRW", "South Korean Won")
            BaseCurrencyItem(R.drawable.jpy, "JPY", "Japanese Yen")
            BaseCurrencyItem(R.drawable.eur, "EUR", "Euro")
        }

        Text(
            text = "Supported conversions include 20 major currencies worldwide. " +
                    "Below is the list of supported currencies with their flags:",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
            modifier = Modifier.padding(vertical = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(majorCurrencies.keys.toList()) { currencyCode ->
                CurrencyGridItem(currencyCode, majorCurrencies[currencyCode] ?: "")
            }
        }
    }
}