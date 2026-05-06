package com.example.newsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> titles, descriptions;
    NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        titles = new ArrayList<>();
        descriptions = new ArrayList<>();

        // 🔥 Static News (NO INTERNET REQUIRED)
        titles.add("India launches new satellite");
        descriptions.add("ISRO successfully launched a new communication satellite.");

        titles.add("AI transforming the world");
        descriptions.add("Artificial Intelligence is rapidly changing industries.");

        titles.add("Sports: India wins match");
        descriptions.add("India secured a thrilling victory in the final over.");

        titles.add("Technology updates");
        descriptions.add("New smartphone released with advanced features.");

        titles.add("Weather update");
        descriptions.add("Heavy rainfall expected in southern regions.");

        adapter = new NewsAdapter(this, titles, descriptions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}