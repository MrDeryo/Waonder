package com.example.myapplication

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay


@Composable
fun AnimatedSplashScreen(navController: NavHostController){
    var startAnimation by remember{ mutableStateOf(false)}
    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(
                durationMillis = 3000
        )
    )
    LaunchedEffect(key1 = true){
        startAnimation=true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screen.LoginScreen.route)

    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha: Float){
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color.Blue,
                        Color.White
                    )
                )
            )
            .fillMaxSize()){
        Image(
            modifier = Modifier
                .alpha(alpha= alpha)
                .size(250.dp),
            painter = painterResource(
            id = R.drawable.pigeon_t),
            contentDescription = "logo"

        )
    }
}

@Composable
@Preview
fun SplashScreenPreview(){
    Splash(alpha = 1f)
}