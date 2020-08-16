package com.example.blood_donation_app;
import android.app.ActionBar;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView date, hospitalName, newDonorName,newDonorEmail, newDonorPhone,newDonorBloodGroup;


    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

         newDonorName = itemView.findViewById(R.id.newDonorName);
         newDonorEmail= itemView.findViewById(R.id.newDonorEmail);
         newDonorPhone = itemView.findViewById(R.id.newDonorPhone);
         newDonorBloodGroup= itemView.findViewById(R.id.newDonorBloodGroup);
        date = itemView.findViewById(R.id.date);
        hospitalName = itemView.findViewById(R.id.hospitalName);

    }
}

