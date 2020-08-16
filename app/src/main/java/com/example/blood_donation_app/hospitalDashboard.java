package com.example.blood_donation_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.viewpager.widget.ViewPager;


public class hospitalDashboard extends AppCompatActivity {
    private Button addDonor, editProfile, recentDonors, hospitalBloodBank;
    private TextView hospitalName;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    public static final String EXTRA_NAME = "com.example.blood_donation_app.EXTRA_NAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_dashboard);
        addDonor = findViewById(R.id.addDonor);
        editProfile = findViewById(R.id.editHospital);
        recentDonors = findViewById(R.id.recentDonors);
        hospitalBloodBank = findViewById(R.id.hospitalBloodBank);
        hospitalName = findViewById(R.id.loggedInHospitalName);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String hospitalUID = user.getUid();
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Hospitals").child(hospitalUID);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = (String) dataSnapshot.child("newHospitalName").getValue();
                hospitalName.setText(name);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



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
        hospitalBloodBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hosName = hospitalName.getText().toString();
                Intent intent  = new Intent(hospitalDashboard.this, hospital_blood_bank.class);
                intent.putExtra(EXTRA_NAME, hosName);
                startActivity(intent);
//                finish();

            }
        });
    }
}
