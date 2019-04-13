package com.example.sammy1997.androidcsdcourse;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.sammy1997.R;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CALL_PHONE;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Activity context;
    DrawerLayout layout;
    NavigationView navigationView;
    static int REQUEST_CALL = 100;
    static int REQUEST_COARSE =  900;
    static int REQUEST_FINE = 800 ;
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
        String number = "6355028935" ;

        context = this;
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Button call = findViewById(R.id.call) ;
        Button send_mail = findViewById(R.id.send_mail) ;
        final EditText subject = findViewById(R.id.subject) ;
        final EditText content = findViewById(R.id.content) ;
        final EditText email_id = findViewById(R.id.mail_id) ;

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(context, CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    // Call another Phone
                    Intent call = new Intent(Intent.ACTION_CALL)  ;
                    Uri number = Uri.parse("tel:6355028935") ;
                    call.setData(number) ;
                    startActivity(call);
                }
                 else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{CALL_PHONE}, REQUEST_CALL) ;
                    }

            }
            }
        });
        send_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = "mailto:" + Uri.encode(email_id.getText().toString()) +
                        "?subject=" + Uri.encode(subject.getText().toString()) +
                        "&body=" + Uri.encode(content.getText().toString()) ;
                Uri send_data = Uri.parse(x) ;
                Intent send = new Intent(Intent.ACTION_SENDTO) ;
                send.setData(send_data) ;
                startActivity(Intent.createChooser(send, "send mail using:"));
            }
        });
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL){
            if (grantResults.length >0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                // We will make a call
                Intent call = new Intent(Intent.ACTION_CALL)  ;
                Uri number = Uri.parse("tel:6355028935") ;
                call.setData(number) ;
                startActivity(call);

            }
            else {
                Toast.makeText(context, "Please grant permissions", Toast.LENGTH_SHORT).show();
            }
        }else if (requestCode==REQUEST_FINE){
            Toast.makeText(context, "fine request given", Toast.LENGTH_SHORT).show();
        }
    }
}
