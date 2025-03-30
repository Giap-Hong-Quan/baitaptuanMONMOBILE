package com.example.baitaptuan5_loginwithtkggfirebase

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

@Composable
fun GoogleSignInScreen(auth: FirebaseAuth, googleSignInClient: GoogleSignInClient, navController: NavController) {
    val context = LocalContext.current
    var errorMessage by remember { mutableStateOf("") }       //Nếu có lỗi trong quá trình đăng nhập, giá trị của errorMessage sẽ thay đổi, và UI sẽ hiển thị lỗi này.

    // Xử lý kết quả sau khi chọn tài khoản Google
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->   //khởi tạo một launcher giúp xử lý kết quả
        if (result.resultCode == android.app.Activity.RESULT_OK) {      // Kiểm tra xem Google Sign-In có thành công không.nếu thành công lấy ra dữ liệu email đó
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)   //nếu thành công lấy ra dữ liệu intent là email
            try {
                val account = task.getResult(ApiException::class.java)        // account sẽ chứa thông tin tài khoản Google.
                val credential = GoogleAuthProvider.getCredential(account.idToken, null)   // Lấy mã thông báo (ID Token) từ tài khoản Google.

                auth.signInWithCredential(credential).addOnCompleteListener { task ->      // thành công chuyển đến profile
                    if (task.isSuccessful) {
                        navController.navigate("profile") {
                            popUpTo("login") { inclusive = true } // Xóa màn login khỏi stack
                        }
                    } else {
                        errorMessage = "Đăng nhập thất bại!"
                    }
                }
            } catch (e: Exception) {
                Log.e("GoogleSignInScreen", "Google Sign-In failed", e)
                errorMessage = "Google Sign-In thất bại!"
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(R.drawable.uth_logo), contentDescription = "Logo")
        Spacer(modifier = Modifier.height(16.dp))
        Text("SmartTasks", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("A simple and efficient to-do app", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(16.dp))

        // Nút đăng nhập Google (Đã thêm logic kích hoạt launcher)
        Button(
            onClick = {   googleSignInClient.signOut().addOnCompleteListener {
                launcher.launch(googleSignInClient.signInIntent)
            } },
            shape = RoundedCornerShape(12.dp)
        ) {
            Icon(painter = painterResource(R.drawable.ic_google), contentDescription = "Google")
            Spacer(modifier = Modifier.width(8.dp))
            Text("SIGN IN WITH GOOGLE")
        }

        // Hiển thị lỗi nếu có
        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(errorMessage, color = Color.Red, fontSize = 14.sp)
        }
    }
}
