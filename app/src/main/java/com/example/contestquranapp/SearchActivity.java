package com.example.contestquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.contestquranapp.databinding.ActivitySearchBinding;

public class SearchActivity extends DrawerBaseActivity {

    ActivitySearchBinding  activitySearchBinding;
    EditText query;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activitySearchBinding = ActivitySearchBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(activitySearchBinding.getRoot());

        query = findViewById(R.id.query);
        btn = findViewById(R.id.search_btn);

        DBHelper dbHelper = new DBHelper(getApplicationContext());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = dbHelper.getSurah(query.getText().toString());

                if (index == -1) {
                    Toast.makeText(getBaseContext(), "Could not find anything", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), SurahActivity.class);
                intent.putExtra("surah_id", index);
                startActivity(intent);
            }
        });
    }
}