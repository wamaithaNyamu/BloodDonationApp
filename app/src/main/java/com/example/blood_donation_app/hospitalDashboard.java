package com.example.blood_donation_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;


public class hospitalDashboard extends AppCompatActivity {
    private Button addDonor, editProfile, recentDonors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_dashboard);
        addDonor = findViewById(R.id.addDonor);
        editProfile = findViewById(R.id.editHospital);
        recentDonors = findViewById(R.id.recentDonors);

        addDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(hospitalDashboard.this, hospital_new_donor.class);
                startActivity(intent);
//                finish();

            }
        });
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(hospitalDashboard.this, hospital_profile.class);
                startActivity(intent);
//                finish();

            }
        });


        recentDonors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(hospitalDashboard.this, hospital_recent_donor.class);
                startActivity(intent);
//                finish();

            }
        });
    }
}
