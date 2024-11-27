package com.bcit.currencyapp.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcit.currencyapp.R
import com.bcit.currencyapp.component.CurrencyCardLazyColumn
import com.bcit.currencyapp.component.CurrencyHeader

@Composable
fun EURPage(currency: Map<*, *>) {
    Column(modifier = Modifier.padding(vertical = 5.dp)) {
        CurrencyHeader("EUR", "Euro", R.drawable.eur)
        CurrencyCardLazyColumn(currency, "eur")
    }
}