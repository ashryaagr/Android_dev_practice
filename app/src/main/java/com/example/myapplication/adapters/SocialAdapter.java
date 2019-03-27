package com.example.myapplication.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.models.SocialItem;

import java.util.List;

public class SocialAdapter extends ArrayAdapter<SocialItem> {

    List<SocialItem> items ;
    Activity context;

    public SocialAdapter(@NonNull Activity context, @NonNull List<SocialItem> objects) {
        super(context, R.layout.social_item_view, objects);
        items = objects;
        this.context = context;
    }

    ;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //    return super.getView(position, convertView, parent);
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.social_item_view, parent, false); // Attach to root means parent also knows on clicking the child

        TextView name = v.findViewById(R.id.name);
        TextView desc = v.findViewById(R.id.description);
        TextView type = v.findViewById(R.id.type);
        ImageView icon = v.findViewById(R.id.app_icon);

        SocialItem item = items.get(position);

        name.setText(item.getName());
        type.setText(item.getType());
        desc.setText(item.getDescription());
        icon.setImageResource(item.getImage_resource_id());

        Typeface medium = Typeface.createFromAsset(context.getAssets(), "fonts/medium.ttf");


        name.setTypeface(medium);
        desc.setTypeface(medium);


        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ((TextView) v.findViewById(R.id.name)).getText(), Toast.LENGTH_LONG).show();
                ;
            }
        });
        return v;
    }
}
