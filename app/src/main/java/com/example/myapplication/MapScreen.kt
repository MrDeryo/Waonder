package com.example.myapplication

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CameraPosition

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions

import com.google.maps.android.compose.*



@Composable
fun MapScreen() {
    Box(modifier = Modifier.fillMaxSize()){
        MapFun()
    }

}


@Composable
fun MapFun(){
    val context= LocalContext.current
    var markerPosition : LatLng by remember { mutableStateOf(LatLng(0.0,0.0)) }
    var lastPosition : LatLng by remember { mutableStateOf(LatLng(0.0,0.0)) }
    var markerPositions: ArrayList<LatLng> by remember { mutableStateOf(ArrayList())}
    val uiSettings by remember { mutableStateOf(MapUiSettings()) }
    val properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.NORMAL))
    }
    var cameraPositionState = rememberCameraPositionState{
        position = CameraPosition.fromLatLngZoom(MainActivity.lastLocation,10f)

    }

    GoogleMap(
        cameraPositionState = cameraPositionState,
        modifier = Modifier.fillMaxSize(),
        properties = properties,
        uiSettings = uiSettings,
        onMapLongClick = {
            Log.d("SIZE", markerPositions.size.toString())
            val toast = Toast.makeText(context,it.toString(),Toast.LENGTH_SHORT)
            toast.show()
            markerPosition=it
            markerPositions.add(it)
        }
    )
    {
        lastPosition = MainActivity.lastLocation
        Marker(state = MarkerState(position = lastPosition),)
        cameraPositionState = rememberCameraPositionState{
            position = CameraPosition.fromLatLngZoom(LatLng(lastPosition.latitude,lastPosition.longitude),5f)

        }


        Marker(state = MarkerState(position = markerPosition))
        for(it : LatLng in markerPositions ) {
            Marker(
                state = MarkerState(
                    position = it
                ),

            )
        }

    }



}






