package com.example.blood_donation_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class onlySignup extends AppCompatActivity {
    private ImageButton donorSignup, hospitalSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_only_signup);

        donorSignup = findViewById(R.id.donorImageSignup);
        donorSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent  = new Intent(onlySignup.this, donorSignup.class);
                startActivity(intent);
//                finish();
            }
        });


        hospitalSignup = findViewById(R.id.hospitalImageSignup);
        hospitalSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent  = new Intent(onlySignup.this, hospitalSignup.class);
                startActivity(intent);
//                finish();
            }
        });


    };
};
