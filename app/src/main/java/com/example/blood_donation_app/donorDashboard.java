package com.example.blood_donation_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class donorDashboard extends AppCompatActivity {
    private ImageButton historyDonations, DonorProfile;
    Button DonorLogoutbutton;
    private TextView loggedInDonorName;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    public static final String EXTRA_NAME = "com.example.blood_donation_app.EXTRA_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_dashboard);

        historyDonations = findViewById(R.id.historyDonations);
        DonorProfile = findViewById(R.id.DonorProfile);

        loggedInDonorName = findViewById(R.id.loggedInDonorName);
        DonorLogoutbutton = findViewById(R.id.DonorLogoutbutton);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String hospitalUID = user.getUid();
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Users").child(hospitalUID);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = (String) dataSnapshot.child("newDonorName").getValue();
                loggedInDonorName.setText(name);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        DonorProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(donorDashboard.this, donor_profile.class);
                startActivity(intent);
//                finish();

            }
        });
        historyDonations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String donorName = loggedInDonorName.getText().toString();
                Intent intent  = new Intent(donorDashboard.this, donor_recent_donations.class);
                intent.putExtra(EXTRA_NAME, donorName);
                startActivity(intent);
            }
        });



        DonorLogoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(donorDashboard.this, MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();

//                finish();

            }
        });

    }
}




