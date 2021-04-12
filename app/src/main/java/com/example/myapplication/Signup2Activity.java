package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Signup2Activity extends AppCompatActivity {

    int checkBoxVisible = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button cross = (Button)findViewById(R.id.cross_button);
        Button creataccount = (Button)findViewById(R.id.signup_button);
        ImageView checkbox = (ImageView) findViewById(R.id.checkbox_imageView);
        TextView checktext = (TextView) findViewById(R.id.textView_check);

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goto_first();
            }
        });

        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });

        checktext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });

        creataccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goto_listentab();
            }
        });

    }

    public void goto_first() {
        Intent it = new Intent(this,LoginsignupActivity.class);
        startActivity(it);
    }
    public void check() {
        ImageView tick = (ImageView) findViewById(R.id.tick_imageView);
        if (checkBoxVisible == 0){
            tick.setVisibility(View.INVISIBLE);
            checkBoxVisible = 1;
        }else if (checkBoxVisible == 1){
            tick.setVisibility(View.VISIBLE);
            checkBoxVisible = 0;
        }
    }
    public void goto_listentab() {
        Intent it = new Intent(this,BottomNavigationActivity.class);
        startActivity(it);
    }

}