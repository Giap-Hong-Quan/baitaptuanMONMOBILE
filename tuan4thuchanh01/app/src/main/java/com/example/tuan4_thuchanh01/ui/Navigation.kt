package com.example.tuan4_thuchanh01.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuan4_thuchanh01.ui.screens.DetailScreen
import com.example.tuan4_thuchanh01.ui.screens.ListScreen

import com.example.tuan4_thuchanh01.ui.screens.RootScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "root") {
        composable("root") { RootScreen(navController) }
        composable("list") { ListScreen(navController) }
        composable("detail/{itemId}") { backStackEntry ->
            DetailScreen(navController, backStackEntry.arguments?.getString("itemId") ?: "")
        }
    }
}
