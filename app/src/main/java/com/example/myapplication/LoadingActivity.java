package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class LoadingActivity extends AppCompatActivity {


    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        //hide default action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //progressbar thread
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        // Start long running operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (progressStatus == 100){
                        goto_first();
                        finish();
                    }
                }
            }
        }).start();

    }


    public void goto_first() {
        Intent it = new Intent(this,SignupActivity.class);
        startActivity(it);
    }

}