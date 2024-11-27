package com.bcit.currencyapp.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun CurrencyCardLazyColumn(currencyData: Map<*, *>, baseCurrency: String) {
    val majorCurrencies = mapOf(
        "cad" to "$",
        "usd" to "$",
        "krw" to "₩",
        "jpy" to "¥",
        "eur" to "€",
        "gbp" to "£",
        "aud" to "$",
        "cny" to "¥",
        "chf" to "CHF",
        "hkd" to "$",
        "inr" to "₹",
        "sgd" to "$",
        "brl" to "R$",
        "zar" to "R",
        "mxn" to "$",
        "rub" to "₽",
        "aed" to "د.إ",
        "sek" to "kr",
        "nzd" to "$",
        "try" to "₺"
    )
    LazyColumn(
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(majorCurrencies.entries.toList()) { currency ->
            CurrencyCard(currency.key, currencyData[currency.key], currency.value, baseCurrency)
        }
    }

}