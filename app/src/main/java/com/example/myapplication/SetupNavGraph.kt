package com.example.myapplication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
        composable(route= Screen.Splash.route){
            AnimatedSplashScreen(navController= navController)
        }
        composable(route= Screen.LoginScreen.route){
            LoginPage(navController = navController)
        }
        composable(route= Screen.RegisterScreen.route){
            RegisterPage(navController= navController)
        }
        composable(route= Screen.MapScreen.route){
            MapScreen()
        }
    }

}
