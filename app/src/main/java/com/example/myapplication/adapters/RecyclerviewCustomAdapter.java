package com.example.myapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerviewCustomAdapter extends RecyclerView.Adapter<RecyclerviewCustomAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView type;
        TextView desc;
        ImageView icon;

        public ViewHolder(View v) {
            super(v);
            //name = v.findViewById(R.id.) ;
            // so on ......and an inflator
        }
    }
}
