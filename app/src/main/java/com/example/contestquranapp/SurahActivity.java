package com.example.contestquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.contestquranapp.databinding.ActivityMainBinding;
import com.example.contestquranapp.databinding.ActivitySurahBinding;

import java.util.ArrayList;

public class SurahActivity extends DrawerBaseActivity {
    ActivitySurahBinding activitySurahBinding;
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activitySurahBinding = ActivitySurahBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(activitySurahBinding.getRoot());

        Intent intent = getIntent();
        int surahId = intent.getIntExtra("surah_id", 0);
        int parasId = intent.getIntExtra("paras_id", 0);

        DBHelper dbHelper = new DBHelper(this.getApplicationContext());

        lst = findViewById(R.id.list_surah);
        CustomAdapter adapter;
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  data);
        if ( parasId != 0 ) {
            adapter = new CustomAdapter(this, R.layout.custom_list,  dbHelper.getPara(parasId) );
        } else {
            adapter = new CustomAdapter(this, R.layout.custom_list,  dbHelper.getAyahs(surahId) );
        }

        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView engTrans = view.findViewById(R.id.eng_trans);
                TextView urduTrans = view.findViewById(R.id.urdu_trans);

                engTrans.setVisibility(engTrans.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                urduTrans.setVisibility(urduTrans.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });

    }
}