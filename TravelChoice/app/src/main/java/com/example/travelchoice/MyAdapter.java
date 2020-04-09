package com.example.travelchoice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context context;
    ArrayList<Model> models;

    public MyAdapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);

        return new MyHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.titleRV.setText(models.get(position).getTitle());
        holder.descriptionRV.setText(models.get(position).getDescription());
        holder.imageViewRV.setImageResource(models.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
