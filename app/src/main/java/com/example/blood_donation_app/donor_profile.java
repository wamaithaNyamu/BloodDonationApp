package com.example.blood_donation_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class donor_profile extends AppCompatActivity {
    Button DonorLogoutButton;
    private EditText newDonorName, newDonorID, newDonorEmail, newDonorPhone,newDonorLocation,newDonorDate;
    private Button updateDonorDetails;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    DatabaseReference child;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_profile);
        newDonorName = findViewById(R.id.newDonorName);
        newDonorID = findViewById(R.id.newDonorID);
        newDonorEmail = findViewById(R.id.newDonorEmail);
        newDonorPhone = findViewById(R.id.newDonorPhone);
        newDonorLocation = findViewById(R.id.newDonorLocation);
        updateDonorDetails = findViewById(R.id.updateDonorDetails);



        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Users");
// Declare this publicly in the class level
        ValueEventListener listener;
        updateDonorDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String DonorUID = user.getUid();
                //get all the values from the text fields
                String strDonorname = newDonorName.getText().toString();
                String strDonorid = newDonorID.getText().toString();
                String strDonoremail = newDonorEmail.getText().toString();
                String strDonorphone = newDonorPhone.getText().toString();
                String strnewDonorLocation = newDonorLocation.getText().toString();

                DonorProfileHelper helper = new DonorProfileHelper(strDonorname,strDonorid,strDonoremail,strDonorphone,strnewDonorLocation);


                //push values into users
                //reference.setValue(helper);
                reference.child(DonorUID).setValue(helper);
                Toast.makeText(donor_profile.this, "Profile Created", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(donor_profile.this, donorDashboard.class);
                startActivity(intent);
            }
        });







        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String DonorUID = user.getUid();

        child = reference.child(DonorUID);
        child.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String strDonorname = dataSnapshot.child("newDonorName").getValue().toString();
                String strDonorid  = dataSnapshot.child("newDonorID").getValue().toString();
                String strDonoremail = dataSnapshot.child("newDonorEmail").getValue().toString();
                String strDonorphone  = dataSnapshot.child("newDonorPhone").getValue().toString();
                String strnewDonorLocation = dataSnapshot.child("newDonorLocation").getValue().toString();

                newDonorName.setText(strDonorname);
                newDonorID.setText(strDonorid);
                newDonorEmail.setText(strDonoremail);
                newDonorPhone.setText(strDonorphone);
                newDonorLocation.setText(strnewDonorLocation);


            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(donor_profile.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });










    }
}
