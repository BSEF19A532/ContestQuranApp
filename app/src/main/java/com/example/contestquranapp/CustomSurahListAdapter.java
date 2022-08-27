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
import java.util.List;

public class CustomSurahListAdapter extends ArrayAdapter<SurahListModel>  {
    ArrayList<SurahListModel> data;

    public CustomSurahListAdapter(@NonNull Context context, int resource, ArrayList<SurahListModel> data) {
        super(context, resource, data);
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.custom_surah_list_item, null, true);
        SurahListModel item = data.get(position);
        ((TextView) view.findViewById(R.id.eng_surah)).setText((position + 1) + " - " + item.getEngSurahName());
        ((TextView) view.findViewById(R.id.urdu_surah)).setText(item.getUrduSurahName());
//        ((TextView) view.findViewById(R.id.urdu_surah_intro)).setText(item.getUrduSurahIntro());
        return view;
    }
}
