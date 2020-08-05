package com.example.blood_donation_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class onlyLogins extends AppCompatActivity {
    private ImageButton donorLogin, hospitalLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_only_logins);

        donorLogin = findViewById(R.id.donorImageLogin);
        donorLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent  = new Intent(onlyLogins.this, donorLogin.class);
                startActivity(intent);
                finish();
            }
        });


        hospitalLogin = findViewById(R.id.hospitalImageLogin);
        hospitalLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent  = new Intent(onlyLogins.this, hospitalLogin.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
