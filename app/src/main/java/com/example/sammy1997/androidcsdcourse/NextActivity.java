package com.example.sammy1997.androidcsdcourse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sammy1997.androidcsdcourse.adapters.CustomListAdapter;
import com.example.sammy1997.androidcsdcourse.adapters.RecyclerviewCustomAdapter;
import com.example.sammy1997.androidcsdcourse.models.SocialItem;

import java.util.ArrayList;
import com.example.sammy1997.R;

public class NextActivity extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    ArrayList<SocialItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        items = new ArrayList<>();

        SocialItem twitter = new SocialItem("Twitter", "Social App", "Yolo description", R.drawable.twitter);
        SocialItem facebook = new SocialItem("Facebook", "Social App", "Some description", R.drawable.facebook);

        items.add(twitter);
        items.add(facebook);

        RecyclerviewCustomAdapter adapter = new RecyclerviewCustomAdapter(this, items);
        recyclerView.setAdapter(adapter);
    }
}
