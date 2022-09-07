package com.example.myapplication.db;

import com.example.myapplication.chat.FriendlyMessage;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataBaseManager {

    private static DataBaseManager instanceDBM;
    private FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mDatabase;
    public DatabaseReference mPositions;

    private DataBaseManager() {
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase = mFirebaseDatabase.getReference().child("message");
        mPositions = mFirebaseDatabase.getReference().child("positions");


    }

public static DataBaseManager getInstance(){
       if(instanceDBM==null){
           instanceDBM= new DataBaseManager();
       }
        return instanceDBM;
}

public void sendMessage(String message, String username){
    FriendlyMessage friendlyMessage = new FriendlyMessage(message, username);
    mDatabase.push().setValue(friendlyMessage);
}

public void savePosition(String username, LatLng position){
    Positions positions = new Positions(username,position.latitude,position.longitude);
    mPositions.push().setValue(positions);

}

}