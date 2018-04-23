package com.example.jjsampayo.livedata;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

public class ActivityMain extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.act_main_recycler_view);
        progressBar  = findViewById(R.id.act_main_progress);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar.setVisibility(View.VISIBLE);

        ViewModelMain model = ViewModelProviders.of(this).get(ViewModelMain.class);

        model.getGodsList().observe(this, mData -> {
                AdapterMain adapter = new AdapterMain(getApplicationContext(), mData);

                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
        });

    }
}
