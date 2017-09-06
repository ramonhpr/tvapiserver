package com.example.ramon.seriestvmaze;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    TVMazeAPI tvApi;
    List<Serie> list_series=null;
    RVAdapter rva ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        tvApi.getSeries(new Callback() {
            @Override
            public void onResponse(Object results) {
                list_series = (List<Serie>) results;
                rva = new RVAdapter(list_series);
            }
        });

    }
}
