package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun SetupNavGraph(navController: NavHostController) {
    val auth by lazy {
        Firebase.auth
    }
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
        composable(route= Screen.Splash.route){
            AnimatedSplashScreen(navController= navController)
        }
        composable(route= Screen.LoginScreen.route){
            LoginPage(navController = navController,auth)
        }
        composable(route= Screen.RegisterScreen.route){
            RegisterPage(navController= navController,auth)
        }
        composable(route= Screen.MapScreen.route){
            MapScreen()
        }
        composable(route= Screen.HomeScreen.route){
            HomePage(navController= navController)
        }
    }

}
