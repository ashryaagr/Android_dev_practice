package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity activity = this ;
        setContentView(R.layout.activity_main2);
        Log.e("In Oncreate", "Main") ;
        Toast.makeText(activity, "Hey", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(activity, MainActivity.class) ;
        intent.putExtra("DATA", "Hello") ;
        startActivity(intent);
    }
}
