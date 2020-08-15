package com.example.blood_donation_app;
import android.app.ActionBar;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class RecyvlerViewHolder extends RecyclerView.ViewHolder {
    public TextView newDonorName,newDonorEmail, newDonorPhone,newDonorBloodGroup;


    public RecyvlerViewHolder(@NonNull View itemView) {
        super(itemView);

         newDonorName = itemView.findViewById(R.id.newDonorName);
         newDonorEmail= itemView.findViewById(R.id.newDonorEmail);
         newDonorPhone = itemView.findViewById(R.id.newDonorPhone);
         newDonorBloodGroup= itemView.findViewById(R.id.newDonorBloodGroup);


    }
}

