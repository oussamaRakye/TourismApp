package com.example.travelchoice;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder {

    ImageView imageViewRV;
    TextView titleRV, descriptionRV;
    Context context;

    public MyHolder(@NonNull View itemView, Context context) {
        super(itemView);

        this.context = context;
        imageViewRV = itemView.findViewById(R.id.imageCV);
        titleRV = itemView.findViewById(R.id.textCV);
        descriptionRV = itemView.findViewById(R.id.descriptionCV);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, InformationActivity.class);

                Pair[] pairs = new Pair[2];

                pairs[0] = new Pair<View, String>(imageViewRV, "image");
                pairs[1] = new Pair<View, String>(titleRV, "name");

                intent.putExtra("city", titleRV.getText());

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
                context.startActivity(intent, activityOptions.toBundle());
            }
        });
    }
}
