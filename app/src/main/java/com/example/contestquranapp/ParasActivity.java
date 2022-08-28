package com.example.contestquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.contestquranapp.databinding.ActivityParasBinding;

import java.util.ArrayList;

public class ParasActivity extends DrawerBaseActivity {

    ActivityParasBinding activityParasBinding;

    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activityParasBinding = ActivityParasBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(activityParasBinding.getRoot());

        lst = findViewById(R.id.para_list_view);
        ArrayList<String> data = new ArrayList<>();
        for (int i = 1; i <= 30; i++)
            data.add("Para " + i);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ParasActivity.this, SurahActivity.class);
                intent.putExtra("paras_id", i + 1);
                startActivity(intent);
            }
        });

    }
}