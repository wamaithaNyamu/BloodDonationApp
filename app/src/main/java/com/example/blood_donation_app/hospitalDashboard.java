package com.example.blood_donation_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;


public class hospitalDashboard extends AppCompatActivity {
    private Button addDonor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_dashboard);
        addDonor = findViewById(R.id.addDonor);

        addDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(hospitalDashboard.this, hospital_new_donor.class);
                startActivity(intent);
//                finish();

            }
        });
    }
}
