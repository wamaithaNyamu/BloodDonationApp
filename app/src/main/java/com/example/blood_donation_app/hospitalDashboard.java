package com.example.blood_donation_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class hospitalDashboard extends AppCompatActivity {
    private ImageButton addDonorImage, bloodBank, profileImage, recentDonors;
    Button hospitalLogoutButton;
    private TextView hospitalName;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    public static final String EXTRA_NAME = "com.example.blood_donation_app.EXTRA_NAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_dashboard);
        addDonorImage = findViewById(R.id.addDonorImage);
        profileImage = findViewById(R.id.profileButtonImage);
        recentDonors = findViewById(R.id.recentDonorsImage);
        bloodBank = findViewById(R.id.bloodBankImage);
        hospitalName = findViewById(R.id.loggedInHospitalName);
        hospitalLogoutButton = findViewById(R.id.hospitalLogoutbutton);
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



        addDonorImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(hospitalDashboard.this, hospital_new_donor.class);
                startActivity(intent);
//                finish();

            }
        });
        profileImage.setOnClickListener(new View.OnClickListener() {
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
        bloodBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hosName = hospitalName.getText().toString();
                Intent intent  = new Intent(hospitalDashboard.this, hospital_blood_bank.class);
                intent.putExtra(EXTRA_NAME, hosName);
                startActivity(intent);
//                finish();

            }
        });

        hospitalLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hospitalDashboard.this, MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();

//                finish();

            }
        });

    }
}
