package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomePage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)

        ) {
        Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            Text(
                text = "Benvenuto a ...",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                color=Color.White,
                fontSize = 32.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
            Icon(Icons.Default.WbSunny,
                tint = Color.Yellow,
                modifier = Modifier.padding(16.dp)
                    .size(30.dp),
                contentDescription = "")
        }

        Text(
            text = "seleziona cosa vorresti incrociare",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            color = Color.White,
            fontSize = 16.sp,

            )
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Passeggiata", fontSize = 15.sp)
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text= "Musica & Club", fontSize = 15.sp)
                }

            }
            Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Da Non Perdere", fontSize = 15.sp)
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text= "Shopping", fontSize = 15.sp)
                }
            }
            Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text= "Musei e Visite", fontSize = 15.sp)
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text= "Ristoranti", fontSize = 15.sp)
                }
            }
            Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Teatro", fontSize = 15.sp)
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text= "Parchi", fontSize = 15.sp)
                }
            }
            Box() {

            }
        }

    }
}

@Composable
@Preview
fun Home(){
    HomePage()
}