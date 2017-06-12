package edu.niu.cs.bari.gradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity
    {

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //create the task that will start the MainActivity
        TimerTask timerTask = new TimerTask()
            {
            @Override
            public void run()
                {
                finish();
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
            };//end of timer task

        //create Timer object
        Timer timer = new Timer();
        timer.schedule(timerTask, 3000);
        }//end of onCreate
    }//end of SplashActivity
