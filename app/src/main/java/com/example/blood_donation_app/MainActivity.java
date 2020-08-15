package com.example.blood_donation_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IFirebaseLoadDone {

    private Button allSignups,allLogins;
    private ViewPager sliderViewPager;
    private LinearLayout dots;
    private SliderAdapter sliderAdapter;
    private ProgressDialog progressDialog;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    DatabaseReference reference1;

    IFirebaseLoadDone iFirebaseLoadDone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Blood_Banks");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String hospitalUID = user.getUid();
        reference1 = rootNode.getReference("Hospitals").child(hospitalUID);
        iFirebaseLoadDone = this;
        sliderViewPager = (ViewPager)findViewById(R.id.sliderViewPager);
        sliderViewPager.setPageTransformer(true,new DepthPageTransformer());
        loadHospitals();
        progressDialog= new ProgressDialog(this);
        allSignups = findViewById(R.id.allSignups);
        allSignups.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Please wait ...");
                progressDialog.show();
                progressDialog.setCanceledOnTouchOutside(false);
                FirebaseAuth.getInstance().signOut();
                Intent intent  = new Intent(MainActivity.this, onlySignup.class);
                progressDialog.dismiss();
                startActivity(intent);

//                finish();
            }
        });



        allLogins = findViewById(R.id.alllogins);
        allLogins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent  = new Intent(MainActivity.this, onlyLogins.class);
                startActivity(intent);
//                finish();
            }
        });
        }

    private void loadHospitals() {
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            List<SliderModel> SliderModelList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot hospitalDataSnapshot : dataSnapshot.getChildren())
                    SliderModelList.add(hospitalDataSnapshot.getValue(SliderModel.class));
                iFirebaseLoadDone.onFirebaseLoadSuccess(SliderModelList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                iFirebaseLoadDone.onFirebaseLoadFailed(databaseError.getMessage());
            }
        });

    }

    @Override
    public void onFirebaseLoadSuccess(List<SliderModel> SliderModelList) {
        sliderAdapter = new SliderAdapter(this,SliderModelList);
        sliderViewPager.setAdapter(sliderAdapter);
    }

    @Override
    public void onFirebaseLoadFailed(String message) {

    }
};


