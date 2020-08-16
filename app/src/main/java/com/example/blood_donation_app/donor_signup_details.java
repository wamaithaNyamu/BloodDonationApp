package com.example.blood_donation_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class donor_signup_details extends AppCompatActivity {
    private EditText newDonorName, newDonorID, newDonorEmail, newDonorPhone,newDonorLocation;
    private Button saveNewDonor;

    private ProgressDialog progressDialog;
    FirebaseDatabase rootNode;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_signup_details);
        newDonorName = findViewById(R.id.newDonorName);
        newDonorID = findViewById(R.id.newDonorID);
        newDonorEmail = findViewById(R.id.newDonorEmail);
        newDonorPhone = findViewById(R.id.newDonorPhone);
        newDonorLocation = findViewById(R.id.newDonorLocation);


        saveNewDonor = findViewById(R.id.saveNewDonor);

        saveNewDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String DonorUID = user.getUid();
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Users");


                //get all the values from the text fields
                String strDonorname = newDonorName.getText().toString();
                String strDonorid = newDonorID.getText().toString();
                String strDonoremail = newDonorEmail.getText().toString();
                String strDonorphone = newDonorPhone.getText().toString();
                String strnewDonorLocation = newDonorLocation.getText().toString();


//                 strAPositive,strANegative,strBPositive,strBNegative,strOPositive,strONegative,strABNegative,strABPositive;
                DonorDetailsSignupHelperClass helper = new DonorDetailsSignupHelperClass(strDonorname,strDonorid,strDonoremail,strDonorphone,strnewDonorLocation);


                //push values into users
                //reference.setValue(helper);
                reference.child(DonorUID).setValue(helper);
                Toast.makeText(donor_signup_details.this, "Profile Created", Toast.LENGTH_SHORT).show();


                Intent intent  = new Intent(donor_signup_details.this, donorDashboard.class);
                startActivity(intent);
            }
        });


    }
}
