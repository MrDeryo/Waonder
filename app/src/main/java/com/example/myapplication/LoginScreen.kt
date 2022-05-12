package com.example.myapplication


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff


import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun LoginPage(navController: NavController){
    val image = painterResource(id = R.drawable.pigeon_t)
    val email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter){
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color.Blue,
                        Color.White
                    )
                )
            )
        ){
            Image(image, contentDescription ="loginLogo" )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(30.dp, 30.dp))
                    .padding(10.dp)
        ) {

            Text(text = "Sign In",
                style = TextStyle(
                fontWeight = FontWeight.Bold,
                letterSpacing = TextUnit.Companion.Unspecified,
            ), fontSize = 24.sp
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(value = email.value,
                    onValueChange ={email.value=it},
                    label ={ Text(text = "Email Address") },
                    placeholder = { Text(text = "Email Address")},
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f)
                    )
                OutlinedTextField(value = password.value,
                    onValueChange ={password.value=it},
                    trailingIcon = {
                        val image = if(passwordVisibility.value)Icons.Filled.VisibilityOff
                        else Icons.Filled.Visibility
                        IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {
                            Icon(
                                imageVector = image,
                                contentDescription = ""
                                )
                        }
                    },
                    label={Text("Password")},
                    placeholder = { Text(text = "Password")},
                    singleLine = true,
                    visualTransformation =if(passwordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(0.8f)
                    )
                Spacer(modifier = Modifier.padding(10.dp))
                Button(onClick = {},
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
                ) {
                    Text(text = "Sign In", fontSize = TextUnit.Companion.Unspecified)
                }
                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    text = "Create An Account",
                    modifier = Modifier.clickable(onClick = {
                        navController.navigate(Screen.LoginScreen.route){
                            launchSingleTop = true
                        }
                    })
                )
                Spacer(modifier = Modifier.padding(20.dp))
                    }

            }


    }

}
