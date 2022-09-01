package com.example.contestquranapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.MyVH> {

    ArrayList<AyahListModel> data;

    public CustomRecyclerAdapter(ArrayList<AyahListModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public CustomRecyclerAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list, parent, false);
        return new CustomRecyclerAdapter.MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerAdapter.MyVH holder, int position) {
        holder.data= data.get(position);
        holder.arabic.setText(holder.data.getArabicText());
        holder.eng_trans.setText(holder.data.getEngTranslation());
        holder.urdu_trans.setText(holder.data.getUrduTranslation());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.eng_trans.setVisibility(holder.eng_trans.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                holder.urdu_trans.setVisibility(holder.urdu_trans.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView arabic;
        TextView eng_trans;
        TextView urdu_trans;
        AyahListModel data;

        public MyVH(@NonNull View itemView) {
            super(itemView);
            arabic = itemView.findViewById(R.id.arabic);
            eng_trans = itemView.findViewById(R.id.eng_trans);
            urdu_trans = itemView.findViewById(R.id.urdu_trans);
        }
    }

}
