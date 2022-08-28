package com.example.contestquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.contestquranapp.databinding.ActivityMainBinding;

public class MainActivity extends DrawerBaseActivity {

    ActivityMainBinding activityMainBinding;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(activityMainBinding.getRoot());

        DBHelper dbHelper = new DBHelper(this.getApplicationContext());

        lst = findViewById(R.id.main_list);
        QDH surahNames = new QDH();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  surahNames.urduSurahNames);
        CustomSurahListAdapter adapter = new CustomSurahListAdapter(this, R.layout.custom_surah_list_item,  dbHelper.getSurahs());
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, SurahActivity.class);
                intent.putExtra("surah_id", i + 1);
                startActivity(intent);
            }
        });
    }
}