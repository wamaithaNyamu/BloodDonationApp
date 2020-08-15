package com.example.blood_donation_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.app.ProgressDialog;


public class hospital_signup_details extends AppCompatActivity {
    private EditText newHospitalName, newHospitalID, newHospitalEmail, newHospitalPhone,newHospitalLocation;
    private Button saveNewHospital;

    private ProgressDialog progressDialog;
    FirebaseDatabase rootNode;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_signup_details);
        newHospitalName = findViewById(R.id.newHospitalName);
        newHospitalID = findViewById(R.id.newHospitalID);
        newHospitalEmail = findViewById(R.id.newHospitalEmail);
        newHospitalPhone = findViewById(R.id.newHospitalPhone);
        newHospitalLocation = findViewById(R.id.newHospitalLocation);


        saveNewHospital = findViewById(R.id.saveNewHospital);

        saveNewHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String hospitalUID = user.getUid();
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Hospitals");


                //get all the values from the text fields
                String strhospitalname = newHospitalName.getText().toString();
                String strhospitalid = newHospitalID.getText().toString();
                String strhospitalemail = newHospitalEmail.getText().toString();
                String strhospitalphone = newHospitalPhone.getText().toString();
                String strnewHospitalLocation = newHospitalLocation.getText().toString();


//                 strAPositive,strANegative,strBPositive,strBNegative,strOPositive,strONegative,strABNegative,strABPositive;
                hospitalDetailsSignupHelperClass helper = new hospitalDetailsSignupHelperClass(strhospitalname,strhospitalid,strhospitalemail,strhospitalphone,strnewHospitalLocation);


                //push values into users
                //reference.setValue(helper);
                reference.child(hospitalUID).setValue(helper);
                Toast.makeText(hospital_signup_details.this, "Profile Created", Toast.LENGTH_SHORT).show();


                Intent intent  = new Intent(hospital_signup_details.this, hospitalDashboard.class);
                startActivity(intent);
            }
        });


    }

}