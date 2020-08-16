package com.example.blood_donation_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class donor_recent_donations extends AppCompatActivity  {
    RecyclerView recyclerView;
    ArrayList<RecyvlerModel> arrayList;
    DatabaseReference reference;
    FirebaseDatabase database;
    FirebaseRecyclerOptions<RecyvlerModel> options;
    FirebaseRecyclerAdapter<RecyvlerModel ,RecyvlerViewHolder > adapter;
    public static final String EXTRA_NAME = "com.example.blood_donation_app.EXTRA_NAME";


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();

    }

    @Override
    protected  void onStop(){
        adapter.stopListening();
        super.onStop();
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        final String DonorName = intent.getStringExtra(donorDashboard.EXTRA_NAME);


        setContentView(R.layout.activity_donor_recent_donations);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String userUID = user.getUid();
        reference = database.getReference().child("New_Donors");
        final Query query = reference.orderByChild("newDonorName").equalTo(DonorName);
        arrayList = new ArrayList<RecyvlerModel>();
        query.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<RecyvlerModel>().setQuery(query, RecyvlerModel.class).build();

        adapter = new FirebaseRecyclerAdapter<RecyvlerModel, RecyvlerViewHolder>(options) {



            @Override
            protected void onBindViewHolder(@NonNull final RecyvlerViewHolder recyvlerViewHolder, int position, @NonNull final RecyvlerModel recyvlerModel) {

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){

                            recyvlerViewHolder.newDonorName.setText(recyvlerModel.getnewDonorName());
                            recyvlerViewHolder.newDonorEmail.setText(recyvlerModel.getnewDonorEmail());
                            recyvlerViewHolder.newDonorPhone.setText(recyvlerModel.getnewDonorPhone());
                            recyvlerViewHolder.newDonorBloodGroup.setText(recyvlerModel.getnewDonorBloodGroup());


                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }

            @NonNull
            @Override
            public RecyvlerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row, parent, false);

                return new RecyvlerViewHolder(v);
            }
        };

        recyclerView.setAdapter(adapter);
    }





}
