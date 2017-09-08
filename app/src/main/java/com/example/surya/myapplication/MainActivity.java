package com.example.surya.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText, editText2;
    Button button;
    String user = "user";
    String pass = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(passwordChecker())


            switch (v.getId()) {
                case R.id.button:
                    startActivity(new Intent(this, newActivity.class));
            }



        }
        public boolean passwordChecker(){
            if(editText.getText().toString().contains(user) && editText2.getText().toString().contains(pass) ){
                Toast.makeText(getApplicationContext(), "Logging you in :)", Toast.LENGTH_SHORT).show();
                return true;
            }

            else if(editText.getText().toString().isEmpty()){

                Toast.makeText(getApplicationContext(), "Please enter user name!", Toast.LENGTH_LONG).show();
                return false;
            }
            else if(editText2.getText().toString().isEmpty()){

                Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
                return false;}
            else if((editText.getText().toString() != user) && editText2.getText().toString().contains("pass")){
                Toast.makeText(getApplicationContext(), "Please enter valid user name", Toast.LENGTH_SHORT).show();
                return false;
            }
            else if((editText2.getText().toString() != pass) && editText.getText().toString().contains("user")){
                Toast.makeText(getApplicationContext(), "Please enter valid password", Toast.LENGTH_SHORT).show();
                return false;
            }
            else if((editText.getText().toString() != user) && editText2.getText().toString() != pass) {
                Toast.makeText(getApplicationContext(), "Please enter valid user name and pass !", Toast.LENGTH_SHORT).show();

                return false;
            }
            else{
                return false;
            }

        }
    }
