package com.example.sammy1997.androidcsdcourse;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sammy1997.androidcsdcourse.adapters.CustomListAdapter;
import com.example.sammy1997.androidcsdcourse.adapters.SocialAdapter;
import com.example.sammy1997.androidcsdcourse.models.Item;
import com.example.sammy1997.androidcsdcourse.models.SocialItem;
import com.example.sammy1997.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ConstraintActivity extends AppCompatActivity {
    ArrayList<SocialItem> items;
    FirebaseAuth auth ;
    FirebaseUser currentUser ;
    FirebaseDatabase database ;

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

        auth = FirebaseAuth.getInstance() ;
        database = FirebaseDatabase.getInstance() ;
        DatabaseReference reference = database.getReference("csdcourses").child("android") ;
        reference.child("student1").child("name").setValue("abcde").addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                
            }
        }) ;
        reference.child("student2").child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class) ;
                Toast.makeText(ConstraintActivity.this, "name changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }) ;
        
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = findViewById(R.id.email) ;
                EditText password = findViewById(R.id.password) ;
                if (currentUser != null) {
                    signIn(email.getText().toString(), password.getText().toString());
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        currentUser = auth.getCurrentUser() ;
        /*if (currentUser != null ){
            
        }*/
    }
    void signIn(String email, String password){
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                // take user to a new activity
                Toast.makeText(ConstraintActivity.this, "U have bee signed up", Toast.LENGTH_SHORT).show();
                currentUser = auth.getCurrentUser() ;
                //currentUser.getEmail() ;

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ConstraintActivity.this, "Some error occured , check yr connection", Toast.LENGTH_SHORT).show();
            }
        }) ;
    }
    void createaccount(String email, String password){
        auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(ConstraintActivity.this, "Signed up", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ConstraintActivity.this, "There was some error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
