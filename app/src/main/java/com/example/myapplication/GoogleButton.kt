package com.example.myapplication


import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GoogleButton(
    text: String = "Sign Up with Google",
    loadingText: String = "Creating Account..."
) {
    var clicked by remember{mutableStateOf(false)}

    Surface(
        onClick = { clicked = !clicked },
        shape = Shapes.medium,
        border = BorderStroke(width= 1.dp, Color.LightGray),
        color = MaterialTheme.colors.surface

    ) {
        Row (
            Modifier.
            padding(
                start = 12.dp,
                end = 16.dp,
                top= 12.dp,
                bottom = 12.dp
            )
                .animateContentSize(
                    animationSpec= tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
                ){
            Icon(painter = painterResource(R.drawable.ic_google_logo),
                contentDescription = "Google Button",
                tint= Color.Unspecified)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text= if(clicked)loadingText else text)
            
            if(clicked){
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color= MaterialTheme.colors.primary
                )
            }
            
            
        }

    }

}

@Preview
@Composable
private fun GoogleButtonPreview(){
    GoogleButton()
}