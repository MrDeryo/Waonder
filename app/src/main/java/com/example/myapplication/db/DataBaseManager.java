package com.example.myapplication.db;

import com.example.myapplication.chat.FriendlyMessage;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataBaseManager {

    private static DataBaseManager instanceDBM;
    private FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mDatabase;

    private DataBaseManager() {
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase = mFirebaseDatabase.getReference().child("message");

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

}