package com.bcit.currencyapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TopBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFF6200EA))
            .statusBarsPadding()
            .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = { navController.navigate("cad") },
            modifier = Modifier.weight(1f).padding(end = 10.dp)
        ) {
            Text("\uD83D\uDCB0", fontSize = 25.sp)
        }
        Text(
            text = "ExchangeMate",
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            ),
            modifier = Modifier
                .weight(6f)
                .clickable { navController.navigate("cad") }
        )
        IconButton(
            onClick = { navController.navigate("about") },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "About Us",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}
