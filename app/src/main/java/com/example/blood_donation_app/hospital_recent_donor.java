package com.example.blood_donation_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class hospital_recent_donor extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<RecyclerModel> arrayList;
    DatabaseReference reference;
    FirebaseDatabase database;
    FirebaseRecyclerOptions<RecyclerModel> options;
    FirebaseRecyclerAdapter<RecyclerModel, RecyclerViewHolder> adapter;


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
        setContentView(R.layout.activity_hospital_recent_donor);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String hospitalUID = user.getUid();
        reference = database.getReference().child("New_Donors");
        final Query query = reference.orderByChild("hospitalUID").equalTo(hospitalUID);
        arrayList = new ArrayList<RecyclerModel>();
        query.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<RecyclerModel>().setQuery(query, RecyclerModel.class).build();

        adapter = new FirebaseRecyclerAdapter<RecyclerModel, RecyclerViewHolder>(options) {



            @Override
            protected void onBindViewHolder(@NonNull final RecyclerViewHolder recyclerViewHolder, int position, @NonNull final RecyclerModel recyclerModel) {

                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){

                            recyclerViewHolder.newDonorName.setText(recyclerModel.getnewDonorName());
                            recyclerViewHolder.newDonorEmail.setText(recyclerModel.getnewDonorEmail());
                            recyclerViewHolder.newDonorPhone.setText(recyclerModel.getnewDonorPhone());
                            recyclerViewHolder.newDonorBloodGroup.setText(recyclerModel.getnewDonorBloodGroup());


                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }

            @NonNull
            @Override
            public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row, parent, false);

                return new RecyclerViewHolder(v);
            }
        };

        recyclerView.setAdapter(adapter);
    }





}
