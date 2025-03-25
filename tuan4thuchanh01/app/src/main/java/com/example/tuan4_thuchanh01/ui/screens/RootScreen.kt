package com.example.tuan4_thuchanh01.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuan4_thuchanh01.R

@Composable
fun RootScreen(navController: NavController) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Hình ảnh
            Image(
                painter = painterResource(id = R.drawable.image1),
                contentDescription = "Navigation Icon",
                modifier = Modifier
                    .size(216.dp)
                    .padding(bottom = 16.dp) // Tạo khoảng cách với Text
            ) // Văn bản mô tả
            Text(
                text = "Navigation ",
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp).padding(bottom = 10.dp)
            )

            // Văn bản mô tả
            Text(
                text = "is a framework that simplifies the implementation of navigation between different UI components (activities, fragments, or composables) in an app",
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp)) // Khoảng cách trước nút bấm

            Button(
                onClick = { navController.navigate("list") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.btn), // Lấy màu từ colors.xml
                    contentColor = Color.White // Màu chữ
                ),
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp, top = 200.dp) // Đặt padding trước
                    .fillMaxWidth() // Nút mở rộng hết phần còn lại sau padding
                    .height(52.dp) // Đặt chiều cao 52dp
            ) {
                Text(
                    text = "PUSH",
                    fontSize = 20.sp
                )
            }

        }
}

