package com.example.surya.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by surya on 11/10/17.
 */

public class UserArea extends AppRegisterActivity {
    private static final String TAG = "UserArea";
    CalendarView calendarView;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_area);
        calendarView = (CalendarView) findViewById(R.id.calendarView);

        Intent intent = getIntent();
        String first_name  = intent.getStringExtra("first_name");


        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        EditText etfirstname = (EditText) findViewById(R.id.etfirstname);


        String message = first_name + "Welcome to HCI App, \nPlease pick available schedule for an Interview.";
        tvWelcomeMsg.setText(message);
        etfirstname.setText(first_name);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (month) + "/" + (dayOfMonth) + "/" + (year);
                Log.d(TAG, "onSelectedDayChange: mm/dd/yyyy" + date);

                Intent intent = new Intent(UserArea.this, SheduleActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);

            }
        });



    }
}
