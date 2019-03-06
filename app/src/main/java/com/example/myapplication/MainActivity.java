package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity activity = this ;
        setContentView(R.layout.activity_main);
        Button button2 ;
        Button button3 ;
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3) ;
        button2.setOnClickListener(this);
//        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();
    }
}
