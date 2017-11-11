package com.example.surya.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by surya on 9/29/17.
 */

public class AppRegisterActivity extends AppCompatActivity {
    EditText etfirstname, etlastname, etemail, etpass, etpass2;
    Button loginbutton, registerbutton;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        etfirstname = (EditText) findViewById(R.id.etfirstname);
        etlastname = (EditText) findViewById(R.id.etlastname);
        etemail = (EditText) findViewById(R.id.etemail);
        etpass = (EditText) findViewById(R.id.etpass);
        etpass2 = (EditText) findViewById(R.id.etpass2);
        loginbutton = (Button) findViewById(R.id.loginbutton);
        registerbutton = (Button) findViewById(R.id.registerbutton);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Log_intent = new Intent(AppRegisterActivity.this, MainActivity.class);
                startActivity(Log_intent);

            }
        });
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //register();

                String first_name = etfirstname.getText().toString();
                String last_name = etlastname.getText().toString();
                String email = etemail.getText().toString();
                String password = etpass.getText().toString();
                //String Password2 = pass2.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                Intent intent = new Intent(AppRegisterActivity.this, MainActivity.class);
                                startActivity(intent);
                                //AppRegisterActivity.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(AppRegisterActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(first_name, last_name, email, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(AppRegisterActivity.this);
                queue.add(registerRequest);




            }



        });
    }



}
