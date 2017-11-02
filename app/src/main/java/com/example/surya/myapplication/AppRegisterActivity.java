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
    EditText firstname, lastname, email, pass, pass2;
    Button loginbutton, registerbutton;

    //String FirstName, LastName, Email, Password, Password2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        pass2 = (EditText) findViewById(R.id.pass2);
        loginbutton = (Button) findViewById(R.id.loginbutton);
        registerbutton = (Button) findViewById(R.id.registerbutton);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //register();

                String FirstName = firstname.getText().toString();
                String LastName = lastname.getText().toString();
                String Email = email.getText().toString();
                String Password = pass.getText().toString();
                String Password2 = pass2.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                Intent intent = new Intent(AppRegisterActivity.this, MainActivity.class);
                                AppRegisterActivity.this.startActivity(intent);
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
                RegisterRequest registerRequest = new RegisterRequest(FirstName,LastName,Email, Password, Password2, responseListener);
                RequestQueue queue = Volley.newRequestQueue(AppRegisterActivity.this);
                queue.add(registerRequest);




            }



        });
    }

//    public void register() {
//
//        FirstName = firstname.getText().toString();
//        LastName = lastname.getText().toString();
//        Email = email.getText().toString();
//        Password = pass.getText().toString();
//        Password2 = pass2.getText().toString();
//        BackGround bg = new BackGround();
//        bg.execute(FirstName, LastName, Email, Password, Password2);
//
//
//    }
//
//    class BackGround extends AsyncTask<String, String, String> {
//
//        @Override
//        protected String doInBackground(String... params) {
//
//            String firstname = params[0];
//            String lastname = params[1];
//            String email = params[2];
//            String pass = params[3];
//            String pass2 = params[4];
//            String data = "";
//            int temp;
//
//            try {
//                URL url = new URL("https://lovethesnipers.000webhostapp.com/newRegister.php");
//                String urlParams = "firstname=" + firstname + "&lastname=" + lastname +
//                        "&email=" + email + "&pass=" + pass + "&pass2=" + pass2;
//
//                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//                httpURLConnection.setDoOutput(true);
//
//                OutputStream os = httpURLConnection.getOutputStream();
//                os.write(urlParams.getBytes());
//                os.flush();
//                os.close();
//
//                InputStream is = httpURLConnection.getInputStream();
//                while ((temp = is.read()) != -1) {
//                    data += (char) temp;
//
//                }
//                is.close();
//                httpURLConnection.disconnect();
//
//                return data;
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//                return "Exception: " + e.getMessage();
//
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            if (s.equals("")) {
//                s = "Register Successful.";
//            }
//            Toast.makeText(AppRegisterActivity.this, s, Toast.LENGTH_LONG).show();
//        }
//    }

}
