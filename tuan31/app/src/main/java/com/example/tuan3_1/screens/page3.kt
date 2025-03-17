package com.example.tuan3_1.screens
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavBackStackEntry
import com.example.tuan3_1.R

@Composable
fun page3(navController: NavController, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth().padding(top = 43.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Chi tiết",
            fontSize = 24.sp,
            color = colorResource(id = R.color.btnready),
            fontWeight = FontWeight(600)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = description, fontSize = 18.sp)
        }
    }
}
