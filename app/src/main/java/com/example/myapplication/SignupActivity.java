package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Button cross = (Button)findViewById(R.id.cross_button);
        Button next = (Button)findViewById(R.id.next_button);

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goto_first();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goto_signup2();
            }
        });
    }

    public void goto_first() {
        Intent it = new Intent(this,LoginsignupActivity.class);
        startActivity(it);
    }

    public void goto_signup2() {
        Intent signup2 = new Intent(this, Signup2Activity.class);
        startActivity(signup2);
    }

}