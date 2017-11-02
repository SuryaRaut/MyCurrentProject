package com.example.surya.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by surya on 9/11/17.
 */

public class SplashScreen  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        Thread timerThread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent splash_intent = new Intent(SplashScreen.this, newMainActivity.class);
                    startActivity(splash_intent);
                    SplashScreen.this.finish();
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}