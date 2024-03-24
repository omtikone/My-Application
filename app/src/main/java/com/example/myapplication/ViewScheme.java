package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewScheme extends AppCompatActivity {

    private ArrayList<SchemeDetails> schemeModalArrayList;
    private DatabaseHandler dbHandler;
    private SchemeRVAdapter schemeRVAdapter;
    private RecyclerView schemeRV;
    private Button applyscheme1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scheme);

        applyscheme1 = (Button) findViewById(R.id.applyscheme);
        schemeModalArrayList = new ArrayList<>();
        dbHandler = new DatabaseHandler(ViewScheme.this);

        // getting our course array
        // list from db handler class.
        schemeModalArrayList = dbHandler.readScheme();

        // on below line passing our array lost to our adapter class.
        schemeRVAdapter = new SchemeRVAdapter(schemeModalArrayList, ViewScheme.this);
        schemeRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewScheme.this, RecyclerView.VERTICAL, false);
        schemeRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        schemeRV.setAdapter(schemeRVAdapter);

        applyscheme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(ViewScheme.this, "Apply successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewScheme.this, HomeActivity.class);
                startActivity(intent);

            }
        });
    }
}