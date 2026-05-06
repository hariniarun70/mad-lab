package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    Context context;
    ArrayList<String> titles, descriptions;

    public NewsAdapter(Context context, ArrayList<String> titles, ArrayList<String> descriptions) {
        this.context = context;
        this.titles = titles;
        this.descriptions = descriptions;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, desc;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(android.R.id.text1);
            desc = itemView.findViewById(android.R.id.text2);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(android.R.layout.simple_list_item_2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.desc.setText(descriptions.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
}