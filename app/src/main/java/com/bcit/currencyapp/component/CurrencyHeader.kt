package com.bcit.currencyapp.component

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

@Composable
fun CurrencyHeader(
    currencyShort: String,
    currencyFull: String,
    flagResId: Int,
    unit: String = "1"
) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = flagResId),
                contentDescription = "$currencyShort flag",
                modifier = Modifier
                    .size(50.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Text("$unit $currencyFull = ", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        }

    }
}