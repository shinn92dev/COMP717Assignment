package com.bcit.currencyapp.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcit.currencyapp.R

@Composable
fun About() {
    val majorCurrencies = mapOf(
        "usd" to "United States Dollar",
        "eur" to "Euro",
        "jpy" to "Japanese Yen",
        "gbp" to "British Pound Sterling",
        "cad" to "Canadian Dollar",
        "aud" to "Australian Dollar",
        "cny" to "Chinese Yuan",
        "chf" to "Swiss Franc",
        "hkd" to "Hong Kong Dollar",
        "krw" to "South Korean Won",
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

@Composable
fun BaseCurrencyItem(flagResId: Int, currencyCode: String, currencyName: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = flagResId),
            contentDescription = "$currencyCode flag",
            modifier = Modifier
                .size(32.dp)
                .aspectRatio(1f),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "$currencyCode ($currencyName)",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        )
    }
}

@SuppressLint("DiscouragedApi")
@Composable
fun CurrencyGridItem(currencyCode: String, currencyName: String) {
    val resourceName =
        if (currencyCode.lowercase() == "try") "turkish_lira" else currencyCode.lowercase()
    val resourceId = LocalContext.current.resources.getIdentifier(
        resourceName,
        "drawable",
        LocalContext.current.packageName
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(4.dp)
    ) {
        Image(
            painter = painterResource(id = resourceId),
            contentDescription = "$currencyCode flag",
            modifier = Modifier
                .size(48.dp)
                .aspectRatio(1f),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(4.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = currencyCode.uppercase(),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                ),
            )
            Text(
                text = currencyName,
                style = TextStyle(
                    fontSize = 7.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                ),
                textAlign = TextAlign.Center

            )
        }

    }
}
