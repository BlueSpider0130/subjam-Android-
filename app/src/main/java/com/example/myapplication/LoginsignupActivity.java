package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginsignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Button signup = (Button) findViewById(R.id.signup_button);
        Button login = (Button) findViewById(R.id.login_button);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextContent();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoLoading();
            }
        });
    }

    private void nextContent() {
        Intent loading = new Intent(this,SignupActivity.class);
        startActivity(loading);
    }
    private void gotoLoading() {
        Intent go = new Intent(this, LoadingActivity.class);
        startActivity(go);
    }




}