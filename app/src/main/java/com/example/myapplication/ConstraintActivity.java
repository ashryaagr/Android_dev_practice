package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.myapplication.adapters.SocialAdapter;
import com.example.myapplication.models.SocialItem;

import java.util.ArrayList;

public class ConstraintActivity extends AppCompatActivity {
    ArrayList<SocialItem> items;
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

        items = new ArrayList<>();

        SocialItem facebook = new SocialItem("facebook", "social app", "yolo desc", R.drawable.facebook) ;
        SocialItem twitter = new SocialItem("twitter", "social app", "yolo desc", R.drawable.twitter) ;
        ListView appList = findViewById(R.id.app_list) ;

        items.add(facebook);
        items.add(twitter);

        SocialAdapter adapter = new SocialAdapter(this, items);
        appList.setAdapter(adapter);
    }
}
