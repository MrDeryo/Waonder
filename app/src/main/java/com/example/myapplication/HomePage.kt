package com.example.myapplication

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.chat.ChatActivity

@Composable
fun HomePage(navController: NavController){
    val context = LocalContext.current
    Box(modifier = Modifier
        .background(
            Brush.linearGradient(
                colors = listOf(
                    Color.Blue,
                    Color.White
                )
            )
        )
        .fillMaxSize()){
        Column() {
            GreetingSection()

            Spacer(modifier = Modifier.padding(20.dp))

            Button(
                onClick = { navController.navigate(Screen.MapScreen.route) },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Map", fontSize = TextUnit.Unspecified)
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Button(
                onClick = {context.startActivity(Intent(context,ChatActivity::class.java)) },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Chat", fontSize = TextUnit.Unspecified)
            }
        }
    }
}
@Composable
fun GreetingSection(
    //name: String prendere il nome da registrazione
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ){
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Ciao!",//, name
                style= MaterialTheme.typography.h2
                )
            Text(text = "Ti auguro una buona giornata",
                style = MaterialTheme.typography.body1)

        }
        //Icon(painter = painterResource(), contentDescription = )
    }
    
}



@Composable
@Preview
fun HomePreview(){
    HomePage(rememberNavController())

}