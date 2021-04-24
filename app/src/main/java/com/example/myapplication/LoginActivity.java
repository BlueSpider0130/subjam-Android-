package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Button login_button = (Button) findViewById(R.id.login_button);
        Button cross = (Button) findViewById(R.id.cross_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GotoLoading();
            }
        });

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goto_first();
            }
        });
    }

    public void GotoLoading() {
        Intent go = new Intent(this, LoadingActivity.class);
        startActivity(go);
    }
    public void goto_first() {
        Intent it = new Intent(this,LoginsignupActivity.class);
        startActivity(it);
    }
}