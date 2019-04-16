package com.example.sammy1997.androidcsdcourse;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.sammy1997.R;
import com.example.sammy1997.androidcsdcourse.fragments.BlankFragment;
import com.example.sammy1997.androidcsdcourse.helpers.DatabaseHelper;
import com.example.sammy1997.androidcsdcourse.models.Student;
import com.example.sammy1997.androidcsdcourse.service.NotificationService;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Activity activity;
    String SERVER_URL = "https://jsonplaceholder.typicode.com/posts" ;
    Button button2;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fabric.with(this, new Crashlytics());
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

        DatabaseHelper db = new DatabaseHelper(this) ;
        Cursor c = db.getElements() ;
        if(c.getCount()>0){
            c.moveToFirst() ;
            while(c.moveToNext()){
                String name = c.getString(1) ;
                int id = c.getInt(0) ;
            }
        }

        Student student = new Student("Shashwat", "EEE", "ds") ;
        db.putElement(student);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment, fragment); //Removed the tag of the fragment as it was creating error
        Button start = findViewById(R.id.start_service) ;
        Button stop = findViewById(R.id.stop_service) ;

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        // Different gestures
        start.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(activity, "LONG CLICK", Toast.LENGTH_SHORT).show();
                return false ;
            }
        });
        start.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Toast.makeText(activity, "Dragged", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Not necessary to write next 4 lines
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addNetworkInterceptor(new StethoInterceptor()) //TEMPORARY object creation
                .connectTimeout(300, TimeUnit.MILLISECONDS)
                .build();

        AndroidNetworking.initialize(getApplicationContext(), okHttpClient); // If we use this, we can utilise this in all activities . //Should be in launcher activity
        fetchdata();
    }

    void fetchdata(){
        JSONObject post_body = new JSONObject() ;
        try {
            post_body.put("id", 1) ;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AndroidNetworking.post(SERVER_URL).addJSONObjectBody(post_body).build().getAsJSONObject(new JSONObjectRequestListener() {

            @Override
            public void onResponse(JSONObject response) {
 //               JSONArray array= null ;
//                for(int i=0; i<response.length(); i++) ;
                try {
                    String title = response.getString("title") ;
                    Toast.makeText(activity, title, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // Log.e("Response", response.toString()) ;
            }

            @Override
            public void onError(ANError anError) {
                Log.e("error in networking", anError.toString()) ;
                Toast.makeText(activity, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        }); ;
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
