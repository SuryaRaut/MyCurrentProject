package com.example.surya.myapplication;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;

/**
 * Created by surya on 9/15/17.
 */

public class DataPackger extends android.app.Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);


    }
}
