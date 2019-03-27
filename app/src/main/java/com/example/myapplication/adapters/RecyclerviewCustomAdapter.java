package com.example.myapplication.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.models.SocialItem;

import java.util.List;

public class RecyclerviewCustomAdapter extends RecyclerView.Adapter<RecyclerviewCustomAdapter.ViewHolder> {

    List<SocialItem> items;
    Activity context;

    RecyclerviewCustomAdapter(Activity context, List<SocialItem> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Inflate view and create ViewHolder
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate();
        return;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        Use holder to bind values
    }

    @Override
    public int getItemCount() {
//        Return size of list
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView desc;
        TextView type;
        ImageView icon;
        public ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            desc = v.findViewById(R.id.description);
            icon = v.findViewById(R.id.app_icon);
        }
    }
}
