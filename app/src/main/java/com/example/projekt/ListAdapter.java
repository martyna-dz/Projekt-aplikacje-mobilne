package com.example.projekt;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter {
    private final Activity context;
    private final int[] sums;
    private final String[] maxes;
    int[] IconIds;

    public ListAdapter(Activity context, int[] sum, String[] maximum, int[] IconIds) {
        super(context, R.layout.mylist, maximum);
        this.context=context;
        this.sums = sum;
        this.maxes = maximum;
        this.IconIds = IconIds;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.mylist, null, true);
        ImageView img = rowView.findViewById(R.id.obrazek);
        TextView progress = (TextView) rowView.findViewById(R.id.progress);
        TextView max = (TextView) rowView.findViewById(R.id.max);
        progress.setText(String.valueOf(sums[position]));
        max.setText(maxes[position]);
        img.setImageResource(IconIds[position]);
        return rowView;
    }
}
