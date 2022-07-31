package com.example.myapplication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.google.maps.android.compose.GoogleMap

@Composable
fun MapScreen() {
    Box(modifier = Modifier.fillMaxSize()){

        MapFun()
    }



}


@Composable
fun MapFun(){



    GoogleMap(Modifier.fillMaxSize())
}