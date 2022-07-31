package com.example.myapplication

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object MapScreen: Screen("map_screen")
    object LoginScreen: Screen ("login_screen")
    object RegisterScreen: Screen("register_screen")
}
