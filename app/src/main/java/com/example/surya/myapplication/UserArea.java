package com.example.surya.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by surya on 11/10/17.
 */

public class UserArea extends AppRegisterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_area);

        Intent intent = getIntent();
        String first_name  = intent.getStringExtra("first_name");


        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        EditText etfirstname = (EditText) findViewById(R.id.etfirstname);


        String message = first_name + "Welcome to our App";
        tvWelcomeMsg.setText(message);
        etfirstname.setText(first_name);



    }
}
