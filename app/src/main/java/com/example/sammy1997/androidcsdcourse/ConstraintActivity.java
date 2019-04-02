package com.example.sammy1997.androidcsdcourse;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.sammy1997.androidcsdcourse.adapters.CustomListAdapter;
import com.example.sammy1997.androidcsdcourse.adapters.SocialAdapter;
import com.example.sammy1997.androidcsdcourse.models.Item;
import com.example.sammy1997.androidcsdcourse.models.SocialItem;
import com.example.sammy1997.R;
import java.util.ArrayList;

public class ConstraintActivity extends AppCompatActivity {
    ArrayList<SocialItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);

        items = new ArrayList<>();

        SocialItem twitter = new SocialItem("Twitter", "Social App", "Yolo description", R.drawable.twitter);
        SocialItem facebook = new SocialItem("Facebook", "Social App", "Some description", R.drawable.facebook);

        ListView appList = findViewById(R.id.app_list);

        items.add(twitter);
        items.add(facebook);

        SocialAdapter adapter = new SocialAdapter(this, items);
        appList.setAdapter(adapter);

    }
}
