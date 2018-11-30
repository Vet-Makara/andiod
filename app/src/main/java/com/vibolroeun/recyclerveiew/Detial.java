package com.vibolroeun.recyclerveiew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Detial extends AppCompatActivity {

    private TextView title, description;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detial);

        extras = getIntent().getExtras();
        title = findViewById(R.id.dTitleID);
        description = findViewById(R.id.dDescID);

        if(extras != null){
            title.setText(extras.getString("title"));
            description.setText(extras.getString("desc"));
        }

    }
}
