package com.example.sammy1997.androidcsdcourse;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sammy1997.R;
import com.example.sammy1997.androidcsdcourse.fragments.BlankFragment;
import com.example.sammy1997.androidcsdcourse.service.NotificationService;

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
        ImageView facebook1, twitter, facebook2 ;
        facebook1 = findViewById(R.id.facebook) ;
        facebook2 = findViewById(R.id.facebook) ;
        twitter = findViewById(R.id.twitter) ;

        getSupportFragmentManager().beginTransaction().add(R.id.fragment, fragment); //Removed the tag of the fragment as it was creating error
        Button start = findViewById(R.id.start_service) ;
        Button stop = findViewById(R.id.stop_service) ;
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(activity, "Button Clicked", Toast.LENGTH_LONG).show();
        switch (v.getId()){
            case R.id.facebook:
                Toast.makeText(activity, "Facebook called", Toast.LENGTH_SHORT).show();
                break;
            case R.id.facebook2:
                Toast.makeText(activity, "Facebook2 called", Toast.LENGTH_SHORT).show();
                break;
            case R.id.twitter:
                Toast.makeText(activity, "Twitter called", Toast.LENGTH_SHORT).show();
                break ;
        }

        switch (v.getId()){
            case R.id.start_service:
                startService(new Intent(this, NotificationService.class)) ;
                break;
            case R.id.stop_service:
                stopService(new Intent(this, NotificationService.class)) ;
                break ;
        }
    }

}
