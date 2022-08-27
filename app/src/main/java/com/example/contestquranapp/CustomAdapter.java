package com.example.contestquranapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<AyahListModel> {

    ArrayList<AyahListModel> data;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<AyahListModel> data) {
        super(context, resource, data);
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.custom_list, null, true);
        AyahListModel item = data.get(position);
        ((TextView) view.findViewById(R.id.arabic)).setText(item.getArabicText());
        ((TextView) view.findViewById(R.id.eng_trans)).setText(item.getEngTranslation());
        ((TextView) view.findViewById(R.id.urdu_trans)).setText(item.getUrduTranslation());
        return view;
    }
}
