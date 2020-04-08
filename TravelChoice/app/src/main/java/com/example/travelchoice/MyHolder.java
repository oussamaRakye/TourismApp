package com.example.travelchoice;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder {

    ImageView imageViewRV;
    TextView titleRV, descriptionRV;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        imageViewRV = itemView.findViewById(R.id.imageCV);
        titleRV = itemView.findViewById(R.id.textCV);
        descriptionRV = itemView.findViewById(R.id.descriptionCV);
    }
}
