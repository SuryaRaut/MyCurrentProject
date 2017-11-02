package com.example.surya.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    TextView newuser;
    Button loginbutton, forgotpass, signupButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //final DatabaseReference databaseUser = FirebaseDatabase.getInstance().getReference("Users");

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        newuser = (TextView) findViewById(R.id.newuser);

        loginbutton = (Button) findViewById(R.id.loginbutton);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DatabaseReference root = FirebaseDatabase.getInstance().getReference();
//                DatabaseReference users = root.child("Users");
//                users.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        if(dataSnapshot.child("userId").exists()){
//
//                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                            builder.setMessage("Login Successful");
//                            Intent login_intent = new Intent(MainActivity.this, newActivity.class);
//                            startActivity(login_intent);
//                            finish();
//
//                        }else{
//                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                            builder.setMessage("Login Failed").setNegativeButton("Retry", null)
//                                    .create().show();
//                            finish();
                        }

                    });

//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
//
//            }
//        });
        forgotpass = (Button) findViewById(R.id.forgotpass);

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgot_intent = new Intent(MainActivity.this, Forgot.class);
                startActivity(forgot_intent);
            }
        });
        signupButton = (Button) findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup_intent = new Intent(MainActivity.this, AppRegisterActivity.class);
                startActivity(signup_intent);
            }
        });

    }







}