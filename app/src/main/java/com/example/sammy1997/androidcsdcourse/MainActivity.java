package com.example.sammy1997.androidcsdcourse;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sammy1997.R;
import com.example.sammy1997.androidcsdcourse.fragments.BlankFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Activity activity;
    Button button2;
    Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_main);
        BlankFragment fragment = new BlankFragment();
//      Loading a fragment
        getSupportFragmentManager().beginTransaction().add(R.id.fragment, fragment, "Tag").commit();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(activity, "Button Clicked", Toast.LENGTH_LONG).show();
    }

}