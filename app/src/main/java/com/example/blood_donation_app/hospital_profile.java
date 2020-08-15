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
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;


public class hospital_profile extends AppCompatActivity {
    Button hospitalLogoutButton;
    private EditText newHospitalName, newHospitalID, newHospitalEmail, newHospitalPhone,newHospitalLocation,newHospitalDate;
    private Button updateHospitalDetails;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    DatabaseReference child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_profile);
        hospitalLogoutButton =findViewById(R.id.hospitalLogoutbutton);
        newHospitalName = findViewById(R.id.newHospitalName);
        newHospitalID = findViewById(R.id.newHospitalID);
        newHospitalEmail = findViewById(R.id.newHospitalEmail);
        newHospitalPhone = findViewById(R.id.newHospitalPhone);
        newHospitalLocation = findViewById(R.id.newHospitalLocation);
        updateHospitalDetails = findViewById(R.id.updateHospitalDetails);



        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Hospitals");
// Declare this publicly in the class level
        ValueEventListener listener;
        updateHospitalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String hospitalUID = user.getUid();
                //get all the values from the text fields
                String strhospitalname = newHospitalName.getText().toString();
                String strhospitalid = newHospitalID.getText().toString();
                String strhospitalemail = newHospitalEmail.getText().toString();
                String strhospitalphone = newHospitalPhone.getText().toString();
                String strnewHospitalLocation = newHospitalLocation.getText().toString();

                hospitalProfileHelper helper = new hospitalProfileHelper(strhospitalname,strhospitalid,strhospitalemail,strhospitalphone,strnewHospitalLocation);


                //push values into users
                //reference.setValue(helper);
                reference.child(hospitalUID).setValue(helper);
                Toast.makeText(hospital_profile.this, "Profile Created", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(hospital_profile.this, hospitalDashboard.class);
                startActivity(intent);
            }
        });




        hospitalLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hospital_profile.this, hospitalLogin.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
               finish();

//                finish();

            }
        });


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String hospitalUID = user.getUid();

        child = reference.child(hospitalUID);
        child.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String strhospitalname = dataSnapshot.child("newHospitalName").getValue().toString();
                String strhospitalid  = dataSnapshot.child("newHospitalID").getValue().toString();
                String strhospitalemail = dataSnapshot.child("newHospitalEmail").getValue().toString();
                String strhospitalphone  = dataSnapshot.child("newHospitalPhone").getValue().toString();
                String strnewHospitalLocation = dataSnapshot.child("newHospitalLocation").getValue().toString();

                newHospitalName.setText(strhospitalname);
                newHospitalID.setText(strhospitalid);
                newHospitalEmail.setText(strhospitalemail);
                newHospitalPhone.setText(strhospitalphone);
                newHospitalLocation.setText(strnewHospitalLocation);


            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(hospital_profile.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });















    }
}
