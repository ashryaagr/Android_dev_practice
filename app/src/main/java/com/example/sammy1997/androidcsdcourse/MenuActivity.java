package com.example.sammy1997.androidcsdcourse;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.sammy1997.R;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Activity context;
    DrawerLayout layout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        layout = findViewById(R.id.drawer);

        ImageView hamburger = findViewById(R.id.hamburger);

        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.openDrawer(GravityCompat.START);
            }
        });
        context = this;
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        layout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()){
            case R.id.inbox:
                Toast.makeText(context, "Inbox", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
