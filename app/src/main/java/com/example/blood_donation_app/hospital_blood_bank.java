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

public class hospital_blood_bank extends AppCompatActivity {
    private EditText APositive, ANegative, BPositive, BNegative,OPositive,ONegative, ABPositive, ABNegative;
    private Button updateBloodBank;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    DatabaseReference child;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_blood_bank);

        updateBloodBank =findViewById(R.id.updateBloodBankDetails);

        APositive = findViewById(R.id.APositive);
        ANegative = findViewById(R.id.ANegative);
        BPositive = findViewById(R.id.BPositive);
        BNegative = findViewById(R.id.BNegative);
        OPositive = findViewById(R.id.OPositive);
        ONegative = findViewById(R.id.ONegative);
        ABNegative = findViewById(R.id.ABNegative);
        ABPositive = findViewById(R.id.ABPositive);

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Blood_Banks");
// Declare this publicly in the class level
        ValueEventListener listener;
        updateBloodBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String hospitalUID = user.getUid();
                //get all the values from the text fields
                String strAPositive = APositive.getText().toString();
                String strANegative = ANegative.getText().toString();
                String strBPositive = BPositive.getText().toString();
                String strBNegative = BNegative.getText().toString();
                String strOPositive = OPositive.getText().toString();
                String strONegative = ONegative.getText().toString();
                String strABNegative = ABNegative.getText().toString();
                String strABPositive = ABPositive.getText().toString();


                BloodBankHelper helper = new BloodBankHelper(hospitalUID,strAPositive,strANegative,strBPositive,strBNegative,strOPositive, strONegative,strABPositive,strABNegative);


                //push values into users
                //reference.setValue(helper);
                reference.child(hospitalUID).setValue(helper);
                Toast.makeText(hospital_blood_bank.this, "Blood bank updated", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(hospital_blood_bank.this, hospitalDashboard.class);
                startActivity(intent);
            }
        });





        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String hospitalUID = user.getUid();

        child = reference.child(hospitalUID);
        child.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){


                        String strAPositive = dataSnapshot.child("apositive").getValue().toString();
                        String strANegative  = dataSnapshot.child("anegative").getValue().toString();
                        String strBPositive = dataSnapshot.child("bpositive").getValue().toString();
                        String strBNegative  = dataSnapshot.child("bnegative").getValue().toString();
                        String strOPositive = dataSnapshot.child("opositive").getValue().toString();
                        String strONegative = dataSnapshot.child("onegative").getValue().toString();
                        String strABNegative  = dataSnapshot.child("abnegative").getValue().toString();
                        String strABPositive = dataSnapshot.child("abpositive").getValue().toString();

                        APositive.setText(strAPositive);
                        ANegative.setText(strANegative);
                        BPositive.setText(strBPositive);
                        BNegative.setText(strBNegative);
                        OPositive.setText(strOPositive);
                        ONegative.setText(strONegative);
                        ABNegative.setText(strABNegative);
                        ABPositive.setText(strABPositive);
                }else{


                        rootNode = FirebaseDatabase.getInstance();
                        reference = rootNode.getReference("Blood_Banks");
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        String hospitalUID = user.getUid();


                        String strAPositive = "0";
                        String strANegative = "0";
                        String strBPositive = "0";
                        String strBNegative = "0";
                        String strOPositive ="0";
                        String strONegative = "0";
                        String strABNegative="0";
                        String strABPositive ="0";

                        BloodBankHelper helper = new BloodBankHelper( strAPositive,strANegative,strBPositive,strBNegative,strOPositive,strONegative,strABPositive,strABNegative);
//        progressBar.setVisibility(View.VISIBLE);
                        reference.child(hospitalUID).setValue(helper);
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//
//                progressBar.setVisibility(View.GONE);
//            }
//        })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        // Write failed
//                        // ...
//                        progressBar.setVisibility(View.GONE);
//                    }
//                });

                    };


            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(hospital_blood_bank.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });














    }
}
