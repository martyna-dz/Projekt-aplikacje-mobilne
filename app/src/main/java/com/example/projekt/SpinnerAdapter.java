package com.example.projekt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class SpinnerAdapter extends ArrayAdapter<String> {

    Context context;
    String[] languages;
    int[] flagIconIds;

    public SpinnerAdapter(Context context, String[] languages, int[] flagIconIds) {
        super(context, R.layout.spinner_item, languages);
        this.context = context;
        this.languages = languages;
        this.flagIconIds = flagIconIds;
    }
    @Override
    public View getDropDownView(int index, View convertView, ViewGroup parent){

        return initView(index, convertView, parent);

    }
    @Override
    public View getView(int index, View convertView, ViewGroup parent){

        return initView(index, convertView, parent);

    }

    private View initView (int index, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_item, parent, false
            );
        }

        TextView text = convertView.findViewById(R.id.textLanguage);
        ImageView imageFlag = convertView.findViewById(R.id.imageFlag);

        text.setText(languages[index]);
        imageFlag.setImageResource(flagIconIds[index]);

        return convertView;
    }
}
