package com.example.blood_donation_app;

import androidx.appcompat.app.AppCompatActivity;

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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class hospital_new_donor extends AppCompatActivity {
    private EditText newDonorName, newDonorID, newDonorEmail, newDonorPhone,newDonorBloodGroup;
    private Button saveNewDonor;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_new_donor);



        newDonorName = findViewById(R.id.newDonorName);
        newDonorID = findViewById(R.id.newDonorID);
        newDonorEmail = findViewById(R.id.newDonorEmail);
        newDonorPhone = findViewById(R.id.newDonorPhone);
        newDonorBloodGroup = findViewById(R.id.newDonorBloodGroup);


        saveNewDonor = findViewById(R.id.saveNewDonor);

        saveNewDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("New_Donors");

                //get all the values from the text fields
                String strdonorname = newDonorName.getText().toString();
                String strdonorid = newDonorID.getText().toString();
                String strdonoremail = newDonorEmail.getText().toString();
                String strdonorphone = newDonorPhone.getText().toString();
                String strnewDonorBloodGroup = newDonorBloodGroup.getText().toString();

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String hospitalUID = user.getUid();
                String currentDatedTime = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                NewDonorHelperClass helper = new NewDonorHelperClass(currentDatedTime,hospitalUID,strdonorname,strdonorid,strdonoremail,strdonorphone,strnewDonorBloodGroup);



                //push values into users
                //reference.setValue(helper);
                reference.child(strdonorid).setValue(helper);

                Toast.makeText(hospital_new_donor.this, "New Donor saved", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(hospital_new_donor.this, hospitalDashboard.class);
                startActivity(intent);
            }
        });


    }
}
