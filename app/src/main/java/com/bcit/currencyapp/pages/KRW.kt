package com.bcit.currencyapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcit.currencyapp.R
import com.bcit.currencyapp.component.CurrencyCardLazyColumn
import com.bcit.currencyapp.component.CurrencyHeader

@Composable
fun KRW(currency: Map<*, *>) {
    Column(modifier = Modifier.padding(vertical = 5.dp)) {
        CurrencyHeader("KRW", "Korean Won", R.drawable.krw, "1000")
        CurrencyCardLazyColumn(currency, "krw")
    }

}