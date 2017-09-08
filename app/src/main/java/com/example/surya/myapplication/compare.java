package com.example.surya.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by surya on 6/5/17.
 */

public class compare extends AppCompatActivity {
    WebView lyft, uber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compare);

        lyft = (WebView) findViewById(R.id.lyft);
        lyft.loadUrl("https://www.lyft.com");
        lyft.getSettings().setJavaScriptEnabled(true);


        uber = (WebView) findViewById(R.id.uber);
        uber.loadUrl("https://www.uber.com");
        uber.getSettings().setJavaScriptEnabled(true);


        //uber = (WebView)  findViewById(R.id.uber);
    }
}