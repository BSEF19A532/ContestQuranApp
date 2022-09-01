package com.example.contestquranapp;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.contestquranapp.databinding.ActivitySurahBinding;

public class SurahActivity extends DrawerBaseActivity {
    ActivitySurahBinding activitySurahBinding;
    ListView lst;
    RecyclerView recyclerView;

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
        recyclerView = findViewById(R.id.recyclerView_surah);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SurahActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        CustomRecyclerAdapter adapter;


//        CustomAdapter adapter;
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  data);
        if ( parasId != 0 ) {
//            adapter = new CustomAdapter(this, R.layout.custom_list,  dbHelper.getPara(parasId) );
            adapter = new CustomRecyclerAdapter(dbHelper.getPara(parasId));
        } else {
//            adapter = new CustomAdapter(this, R.layout.custom_list,  dbHelper.getAyahs(surahId) );
            adapter = new CustomRecyclerAdapter(dbHelper.getAyahs(surahId));
        }

        recyclerView.setAdapter(adapter);
//        lst.setAdapter(adapter);

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