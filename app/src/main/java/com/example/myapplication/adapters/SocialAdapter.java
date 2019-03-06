package com.example.myapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.myapplication.R;
import com.example.myapplication.models.SocialItem;

import java.util.List;

public class SocialAdapter extends ArrayAdapter<SocialItem> {
    List<SocialItem> items ;
    Activity context;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    public SocialAdapter(@NonNull Activity context, int resource, @NonNull List<SocialItem> objects) {
        super(context, R.layout.social_item_view, objects);
        items = objects ;
        this.context = context ;
    }
}
