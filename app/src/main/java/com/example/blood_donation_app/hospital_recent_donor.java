package com.example.blood_donation_app;

import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class hospital_recent_donor extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<RecyvlerModel> arrayList;
    DatabaseReference reference;
    FirebaseDatabase database;
    FirebaseRecyclerOptions<RecyvlerModel> options;
    FirebaseRecyclerAdapter<RecyvlerModel ,RecyvlerViewHolder > adapter;


    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected  void onStop(){
        adapter.stopListening();
        super.onStop();
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_recent_donor);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();

        reference = database.getReference().child("New_Donors");
        arrayList = new ArrayList<RecyvlerModel>();
        reference.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<RecyvlerModel>().setQuery(reference, RecyvlerModel.class).build();

        adapter = new FirebaseRecyclerAdapter<RecyvlerModel, RecyvlerViewHolder>(options) {



            @Override
            protected void onBindViewHolder(@NonNull RecyvlerViewHolder recyvlerViewHolder, int position, @NonNull RecyvlerModel recyvlerModel) {
                recyvlerViewHolder.newDonorName.setText(recyvlerModel.getnewDonorName());
                recyvlerViewHolder.newDonorEmail.setText(recyvlerModel.getnewDonorEmail());
                recyvlerViewHolder.newDonorPhone.setText(recyvlerModel.getnewDonorPhone());
                recyvlerViewHolder.newDonorBloodGroup.setText(recyvlerModel.getnewDonorBloodGroup());
            }

            @NonNull
            @Override
            public RecyvlerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row, parent, false);

                return new RecyvlerViewHolder(v);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }





}
