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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    EditText username, pass;
    TextView newuser;
    Button loginbutton, forgotpass, signupButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);



        username = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.pass);
        newuser = (TextView) findViewById(R.id.newuser);

        loginbutton = (Button) findViewById(R.id.loginbutton);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = username.getText().toString();
                final String  password = pass.getText().toString();

                //Responce received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                String first_name = jsonResponse.getString("first_name");

                                Intent intent = new Intent(MainActivity.this, UserArea.class);
                                intent.putExtra("email", email);
                                intent.putExtra("first_name", first_name);

                                startActivity(intent);
                            }else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                LoginRequest loginRequest = new LoginRequest(email, password, responseListener );
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);

            }
                    });


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