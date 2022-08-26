package com.example.myapplication


import android.annotation.SuppressLint
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff


import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.chat.ChatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


@Composable
fun LoginPage(navController: NavController,auth :FirebaseAuth){

    val focus = LocalFocusManager.current
    val image = painterResource(id = R.drawable.pigeon_t)
    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    val context = LocalContext.current
    //per bottone sign in
    val isEmailValid by remember {
        derivedStateOf {
            Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()
        }
    }
    val isPasswordValid by remember{
        derivedStateOf {
            password.toString().length> 5
        }
    }
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
                    placeholder = { Text(text = "abc@domain.com")},
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions= KeyboardActions(
                        onNext = {focus.moveFocus(FocusDirection.Down)}
                    )//,
                //isError= !isEmailValid
                    )
                OutlinedTextField(value = password.value,
                    onValueChange ={password.value=it},
                    trailingIcon = {
                        val icon = if(passwordVisibility.value)Icons.Filled.VisibilityOff
                        else Icons.Filled.Visibility
                        IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {
                            Icon(
                                imageVector = icon,
                                contentDescription = ""
                                )
                        }
                    },
                    label={Text("Password")},
                    placeholder = { Text(text = "Password")},
                    singleLine = true,
                    visualTransformation =if(passwordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(0.8f),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions= KeyboardActions(
                    onDone = {focus.clearFocus()}
                )//,
                    //isError = !isPasswordValid
                )

                Spacer(modifier = Modifier.padding(10.dp))
                Button(onClick = {
                   auth.signInWithEmailAndPassword(email.value, password.value)
                        .addOnCompleteListener{
                            if(it.isSuccessful){
                                navController.navigate(Screen.HomeScreen.route)
                                val user = auth.currentUser
                                ChatActivity.mUsername= user?.email
                            }else{
                               //toast credenziali incorrette
                                val toast = Toast.makeText(context,"Credenziali incorrette",Toast.LENGTH_SHORT)
                                toast.show()
                            }
                        }


                },//aggiunta al firebase al click
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp),
                    enabled = true//isEmailValid && isPasswordValid
                ) {
                    Text(text = "Log In", fontSize = TextUnit.Companion.Unspecified)
                }
                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    text = "Create An Account",//aggiungere anche "forgot the password"
                    modifier = Modifier.clickable(onClick = {
                        navController.navigate(Screen.RegisterScreen.route){
                            launchSingleTop = true
                        }
                    })
                )
                Spacer(modifier = Modifier.padding(20.dp))
                //test per la navigazione alla home in caso di login / switchare con forgort the password
                TextButton(onClick = {//navController.navigate(Screen.HomeScreen.route)
                    },// creare un nuovo screen modifica password
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)
                ) {
                    Text(text = "Forgot the Password", fontSize = TextUnit.Companion.Unspecified)
                }

            }

            }


    }

}


@Composable
@Preview

fun LoginPreview(){
    LoginPage(rememberNavController(),FirebaseAuth.getInstance())
}