package com.example.standup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton alarmToggle = findViewById(R.id.alarmToggle);

        alarmToggle.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        String toastMessage;
                        if(isChecked){
                            //Set the toast message for the "on" case.
                            toastMessage = "Stand Up Alarm On!";
                        } else {
                            //Set the toast message for the "off" case.
                            toastMessage = "Stand Up Alarm Off!";
                        }

                        //Show a toast to say the alarm is turned on or off.
                        Toast.makeText(MainActivity.this, toastMessage,Toast.LENGTH_SHORT)
                                .show();
                    }
                });

    }
}