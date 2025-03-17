package com.example.tuan3_1.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.clickable
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tuan3_1.R
import com.example.tuan3_1.database.DatabaseHelper
import com.example.tuan3_1.entity.Category
import com.example.tuan3_1.repository.CategoryRepository

@Composable
fun page2(navController: NavHostController, context: Context){
    val dbHelper = remember { DatabaseHelper(context) }
    val repository = remember { CategoryRepository(dbHelper) }
    val categories = remember { mutableStateOf(emptyList<Category>()) }
    // Lấy dữ liệu từ database
    LaunchedEffect(Unit) {
        categories.value = repository.getCategories()
    }
    Column (
        modifier = Modifier
            .fillMaxWidth().padding(top = 43.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "UI Components List",
            fontSize = 24.sp,
            color = colorResource(id =R.color.btnready) ,
            fontWeight = FontWeight(600)
        )
        CategoryScreen(categories.value, navController)
    }
}
@Composable
fun CategoryScreen(categories: List<Category>,navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        categories.forEach { category ->
            // Hiển thị tiêu đề Category
            Text(
                text = category.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(vertical = 8.dp)
            )

            // Hiển thị danh sách các thuộc tính bên trong
            category.attributes.forEach { attribute ->
                ItemCard(attribute.title, attribute.description,navController)
            }
        }
    }
}
@Composable
fun ItemCard(title: String, description: String, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)

            .clickable {
                // ✅ Điều hướng đến page3 với description được encode để tránh lỗi ký tự đặc biệt
                val encodedDescription = java.net.URLEncoder.encode(description, "UTF-8")
                navController.navigate("page3/$encodedDescription")
            },// ✅ Truyền description
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors( // ✅ Đặt màu nền tại đây
            containerColor = colorResource(id = R.color.card))
        ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = description, fontSize = 14.sp, color = Color.DarkGray)
        }
    }
}


