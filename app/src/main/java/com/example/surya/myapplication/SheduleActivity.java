package com.example.surya.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by surya on 11/11/17.
 */

public class SheduleActivity extends AppCompatActivity {
    TextView theDate;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_activity);
        theDate = (TextView) findViewById(R.id.date);

        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        theDate.setText(date);
    }

}
