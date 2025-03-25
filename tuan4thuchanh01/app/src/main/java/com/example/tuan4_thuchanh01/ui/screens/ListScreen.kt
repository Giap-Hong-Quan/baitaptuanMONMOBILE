package com.example.tuan4_thuchanh01.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuan4_thuchanh01.R

@Composable
fun ListScreen(navController: NavController) {
    val items = List(1_000_000) { index -> index to "The only way to do great work is to love what you do." }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            // Icon Back nằm sát bên trái
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(start = 8.dp)
                    .clickable { navController.navigate("root") }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Blue
                )
            }

            // Box chứa chữ, đảm bảo chữ nằm giữa
            Box(
                modifier = Modifier
                    .weight(1f) // Đẩy Box này rộng ra, làm cho chữ nằm giữa
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "LazyColumn",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.btn)
                )
            }
        }


        LazyColumn {
            items(items, key = { it.first }) { (index, text) ->
                ListItem(navController = navController, index = index, text = text)
            }
        }
    }
}

@Composable
fun ListItem(navController: NavController, index: Int, text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFB3E5FC)), // Màu xanh nhạt
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Sử dụng đúng Material 3
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$index | $text",
                fontSize = 14.sp,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Next",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { navController.navigate("detail/$index") }
            )
        }
    }
}
