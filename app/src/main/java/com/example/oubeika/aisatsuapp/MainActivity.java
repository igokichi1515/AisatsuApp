package com.example.oubeika.aisatsuapp;

import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.aisatsu);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button1) {
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minite) {
                        if(view != null){
                            if( (hourOfDay >= 2 && hourOfDay <= 9) && (minite >= 0 && minite <= 59) ){
                                mTextView.setText("おはよう"); //2:00 ~ 9:59
                            }else if( (hourOfDay >= 10 && hourOfDay <= 17) && (minite >= 0 && minite <= 59) ){
                                mTextView.setText("こんにちは"); //10:00 ~ 17:59
                            }else if( (hourOfDay >= 18 && hourOfDay <= 24) || (hourOfDay >= 0 && hourOfDay <= 1) && (minite >= 0 && minite <= 59) ){
                                mTextView.setText("こんばんは"); //18:00 ~ 1:59
                            }
                        }
                    }
                },
                13,
                0,
                true);
        timePickerDialog.show();
    }
}
