package com.example.myapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tuan3_1.R

@Composable
fun page1(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 128.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.anh1),
            contentDescription = "Jetpack Compose",
            modifier = Modifier
                .width(216.dp)
                .height(233.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(301.dp)
        ) {
            Text(
                text = "Jetpack Compose",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(200.dp))

        Button(
            onClick = { navController.navigate("page2")},
            modifier = Modifier
                .width(315.dp)
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.btnready))
        ) {
            Text(
                text = "I'm ready",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}
