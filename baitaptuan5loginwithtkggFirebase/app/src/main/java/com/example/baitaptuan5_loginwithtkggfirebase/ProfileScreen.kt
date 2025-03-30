package com.example.baitaptuan5_loginwithtkggfirebase

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController

import com.google.firebase.auth.FirebaseAuth
import coil.compose.rememberAsyncImagePainter
@Composable
fun ProfileScreen(auth: FirebaseAuth, navController: NavController) {
    val user = auth.currentUser
    val displayName = remember { mutableStateOf(user?.displayName ?: "") }
    val email = remember { mutableStateOf(user?.email ?: "") }
    val birthDate = remember { mutableStateOf("") } // Người dùng có thể nhập ngày sinh
    val photoUrl: Uri? = user?.photoUrl

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Ảnh đại diện
        Box(modifier = Modifier.size(100.dp).clip(CircleShape)) {
            Image(
                painter = rememberAsyncImagePainter(photoUrl ?: "https://via.placeholder.com/100"),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Trường nhập thông tin
        OutlinedTextField(value = displayName.value, onValueChange = { displayName.value = it }, label = { Text("Name") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = email.value, onValueChange = {}, label = { Text("Email") }, enabled = false)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = birthDate.value, onValueChange = { birthDate.value = it }, label = { Text("Date of Birth") })
        Spacer(modifier = Modifier.height(16.dp))

        // Nút đăng xuất
        Button(onClick = {
            auth.signOut()
            navController.navigate("login") {
                popUpTo("profile") { inclusive = true }
            }
        }) {
            Text(text = "Đăng xuất")
        }
    }
}
