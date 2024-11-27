package com.bcit.currencyapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bcit.currencyapp.R

@Composable
fun BottomBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color(0xFFF2F2F2))
            .padding(top = 12.dp, bottom = 20.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = { navController.navigate("cad") },
            modifier = Modifier
                .size(50.dp)
                .border(
                    width = 3.dp,
                    color = Color(0xFF6200EA).copy(alpha = 0.5f),
                    shape = CircleShape
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.cad_round),
                contentDescription = "Canada Flag",
                modifier = Modifier.fillMaxSize()
            )
        }
        IconButton(
            onClick = { navController.navigate("usd") },
            modifier = Modifier
                .size(50.dp)
                .border(
                    width = 3.dp,
                    color = Color(0xFF6200EA).copy(alpha = 0.5f),
                    shape = CircleShape
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.usd_round),
                contentDescription = "US Flag",
                modifier = Modifier.fillMaxSize()
            )
        }
        IconButton(
            onClick = { navController.navigate("krw") },
            modifier = Modifier
                .size(50.dp)
                .border(
                    width = 3.dp,
                    color = Color(0xFF6200EA).copy(alpha = 0.5f),
                    shape = CircleShape
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.krw_round),
                contentDescription = "Korea Flag",
                modifier = Modifier.fillMaxSize()
            )
        }
        IconButton(
            onClick = { navController.navigate("jpy") },
            modifier = Modifier
                .size(50.dp)
                .border(
                    width = 3.dp,
                    color = Color(0xFF6200EA).copy(alpha = 0.5f),
                    shape = CircleShape
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.jpy_round),
                contentDescription = "Japan Flag",
                modifier = Modifier.fillMaxSize()
            )
        }
        IconButton(
            onClick = { navController.navigate("eur") },
            modifier = Modifier
                .size(50.dp)
                .border(
                    width = 3.dp,
                    color = Color(0xFF6200EA).copy(alpha = 0.5f),
                    shape = CircleShape
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.eur_round),
                contentDescription = "Euro Flag",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}