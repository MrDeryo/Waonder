package com.example.myapplication.db;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.chat.FriendlyMessage;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.HashMap;

public class PositionActivity extends AppCompatActivity {
    private ChildEventListener mChildEventListener;
    private DataBaseManager dataBaseManager;
    public static HashMap<String,LatLng> locations = new HashMap<String,LatLng>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        dataBaseManager = DataBaseManager.getInstance();

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Positions position = snapshot.getValue(Positions.class);
                locations.put(position.getUsername(), new LatLng(position.getLat(),position.getLon()));
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Positions position = snapshot.getValue(Positions.class);
                locations.replace(position.getUsername(), new LatLng(position.getLat(),position.getLon()));
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        dataBaseManager.mPositions.addChildEventListener(mChildEventListener);

    }
}
