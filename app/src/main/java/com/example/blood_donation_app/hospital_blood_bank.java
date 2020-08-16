package com.example.blood_donation_app;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
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
    public static final String EXTRA_NAME = "com.example.blood_donation_app.EXTRA_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_blood_bank);
        Intent intent = getIntent();
        final String HospitalName = intent.getStringExtra(hospitalDashboard.EXTRA_NAME);




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
                int strAPositive = Integer.parseInt(String.valueOf(APositive.getText()));
                int strANegative = Integer.parseInt(String.valueOf(ANegative.getText()));

                int strBPositive = Integer.parseInt(String.valueOf(BPositive.getText()));
                int strBNegative = Integer.parseInt(String.valueOf(BNegative.getText()));

                int strOPositive = Integer.parseInt(String.valueOf(OPositive.getText()));
                int strONegative = Integer.parseInt(String.valueOf(ONegative.getText()));

                int strABPositive = Integer.parseInt(String.valueOf(ABPositive.getText()));
                int strABNegative = Integer.parseInt(String.valueOf(ABNegative.getText()));

                BloodBankHelper helper = new BloodBankHelper(HospitalName,strAPositive,strANegative,strBPositive,strBNegative,strOPositive, strONegative,strABPositive,strABNegative);


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
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){

                        Long strAPositive = (Long) dataSnapshot.child("apositive").getValue();
                        Long strANegative = (Long) dataSnapshot.child("anegative").getValue();
                        Long strBPositive = (Long) dataSnapshot.child("bpositive").getValue();
                        Long strBNegative = (Long) dataSnapshot.child("bnegative").getValue();
                        Long strOPositive = (Long) dataSnapshot.child("opositive").getValue();
                        Long strONegative = (Long) dataSnapshot.child("onegative").getValue();
                        Long strABNegative = (Long) dataSnapshot.child("abnegative").getValue();
                        Long strABPositive = (Long) dataSnapshot.child("abpositive").getValue();



                        APositive.setText(String.valueOf(strAPositive));
                        ANegative.setText(String.valueOf(strANegative));
                        BPositive.setText(String.valueOf(strBPositive));
                        BNegative.setText(String.valueOf(strBNegative));
                        OPositive.setText(String.valueOf(strOPositive));
                        ONegative.setText(String.valueOf(strONegative));
                        ABNegative.setText(String.valueOf(strABNegative));
                        ABPositive.setText(String.valueOf(strABPositive));


                }else{


                        rootNode = FirebaseDatabase.getInstance();
                        reference = rootNode.getReference("Blood_Banks");
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        String hospitalUID = user.getUid();


                        int strAPositive = 0;
                        int strANegative = 0;
                        int strBPositive = 0;
                        int strBNegative = 0;
                        int strOPositive =0;
                        int strONegative = 0;
                        int strABNegative=0;
                        int strABPositive =0;

                        BloodBankHelper helper = new BloodBankHelper( HospitalName, strAPositive,strANegative,strBPositive,strBNegative,strOPositive,strONegative,strABPositive,strABNegative);
                        reference.child(hospitalUID).setValue(helper);

                    };


            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(hospital_blood_bank.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });














    }
}
