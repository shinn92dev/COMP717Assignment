package com.bcit.currencyapp.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
