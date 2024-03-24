package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EMarketRaw extends AppCompatActivity {

    Button Buy;
    private DatabaseHandler databaseHandler;
    private RecyclerView recyclerView;
    private RVAdapter rvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emarket_raw);

        Buy=findViewById(R.id.Buy);
        try{
            recyclerView=findViewById(R.id.imagesRV);
            databaseHandler=new DatabaseHandler(this);
        }catch(Exception e){
            Toast.makeText(this, "e.getMessage", Toast.LENGTH_SHORT).show();
        }

        Buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EMarketRaw.this,PaymentActivity.class);
                startActivity(intent);
                Toast.makeText(EMarketRaw.this, "Buy successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getData(View view){
        try{
            rvAdapter=new RVAdapter(databaseHandler.getALLImagesData());
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(rvAdapter);
        }
        catch(Exception e)
        {
            Toast.makeText(this, "e.getMessage", Toast.LENGTH_SHORT).show();
        }

    }
}