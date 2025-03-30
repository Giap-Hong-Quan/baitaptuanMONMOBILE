package com.example.baitaptuan5_loginwithtkggfirebase

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AppNavigation(navController: NavHostController, auth: FirebaseAuth, googleSignInClient: GoogleSignInClient) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { GoogleSignInScreen(auth, googleSignInClient, navController) }
        composable("profile") { ProfileScreen(auth, navController) }
    }
}
