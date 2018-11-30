package com.vibolroeun.recyclerveiew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.myAdapter;
import Model.listItems;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private List<listItems> row;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recyclerID);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        row = new ArrayList<>();
        for(int i=0; i<20; i++){
            listItems item = new listItems(
                    "Title " + (i+1),
                    "This is RecyclerView",
                    ""
            );
            row.add(item);
        }
        adapter = new myAdapter(this, row);
        recycler.setAdapter(adapter);

    }
}
