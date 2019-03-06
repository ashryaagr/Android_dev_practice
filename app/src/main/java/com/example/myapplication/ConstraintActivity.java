package com.example.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.models.SocialItem;

public class ConstraintActivity extends AppCompatActivity {
    //SharedPreferences preferences ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);
        /*preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", "ashryaagr");
        editor.putString("password", "helloworld");
        editor.apply();*/

        SocialItem facebook = new SocialItem("facebook", "social app", "yolo desc", R.drawable.facebook) ;
        SocialItem twitter = new SocialItem("twitter", "social app", "yolo desc", R.drawable.twitter) ;
        ListView appList = findViewById(R.id.app_list) ;
    }
}
