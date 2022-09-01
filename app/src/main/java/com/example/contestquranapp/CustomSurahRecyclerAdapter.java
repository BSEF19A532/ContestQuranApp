package com.example.contestquranapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomSurahRecyclerAdapter extends RecyclerView.Adapter<CustomSurahRecyclerAdapter.MyVH> {

    ArrayList<SurahListModel> data;

    public CustomSurahRecyclerAdapter(ArrayList<SurahListModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public CustomSurahRecyclerAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_surah_list_item, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomSurahRecyclerAdapter.MyVH holder, int position) {
        holder.data= data.get(position);
        holder.eng_surah.setText((position + 1) + " - " + holder.data.getEngSurahName());
        holder.urdu_surah.setText(holder.data.getUrduSurahName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), SurahActivity.class);
                intent.putExtra("surah_id", holder.getAdapterPosition() + 1);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView eng_surah;
        TextView urdu_surah;
        SurahListModel data;

        public MyVH(@NonNull View itemView) {
            super(itemView);
            eng_surah = itemView.findViewById(R.id.eng_surah);
            urdu_surah = itemView.findViewById(R.id.urdu_surah);
        }
    }


}
