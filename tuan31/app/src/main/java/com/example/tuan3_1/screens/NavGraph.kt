package com.example.tuan3_1.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapp.ui.screens.page1
import java.net.URLDecoder
import java.nio.charset.StandardCharsets


@Composable
fun NavGraph(navController: NavHostController) {
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = "page1") {
        composable("page1") { page1(navController) }
        composable("page2") { page2(navController, context) }


        composable("page3/{description}") { backStackEntry ->
            val encodedDescription = backStackEntry.arguments?.getString("description") ?: "Không có dữ liệu"
            val description = URLDecoder.decode(encodedDescription, StandardCharsets.UTF_8.toString())
            page3(navController, description)
        }
    }
}
