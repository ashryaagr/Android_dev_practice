package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.models.SocialItem;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SocialItem facebook = new SocialItem("facebook", "social app", "yolo desc", R.drawable.facebook);
        SocialItem twitter = new SocialItem("twitter", "social app", "yolo desc", R.drawable.twitter);

        ArrayList<SocialItem> list = new ArrayList<>();

        list.add(twitter);
        list.add(facebook);

        layoutManager = new LinearLayoutManager(this);
        //recyclerView = findViewById(R.id.) ;

        recyclerView.setLayoutManager(layoutManager);
        //RecyclerviewCustomAdapter adapter = new RecyclerviewCustomAdapter(this, list) ;
        //recyclerView.setAdapter(adapter);
    }
}
