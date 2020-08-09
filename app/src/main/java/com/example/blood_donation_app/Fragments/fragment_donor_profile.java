package com.example.blood_donation_app.Fragments;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.Toast;

import com.example.blood_donation_app.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.blood_donation_app.donorLogin;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.firebase.auth.FirebaseAuth;

public class fragment_donor_profile extends Fragment {
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v;
        v=inflater.inflate(R.layout.fragment_donor_profile,container,false);

        Button submitBtn=(Button)v.findViewById(R.id.donorLogoutbutton);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent  = new Intent(getActivity(), donorLogin.class);
                startActivity(intent);


                Toast.makeText(getActivity(),"Youve been logged out", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}
//
//(R.layout.fragment2_layout, container, false);