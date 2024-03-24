package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EmarketFarmProduct extends AppCompatActivity {

    private DatabaseHandler databaseHandler;
    private RecyclerView recyclerView;
    private RVAdapter rvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emarket_farm_product);

        try{
            recyclerView=findViewById(R.id.imagesRV);
            databaseHandler=new DatabaseHandler(this);
        }catch(Exception e){
            Toast.makeText(this, "e.getMessage", Toast.LENGTH_SHORT).show();
        }
    }

    public void getProductData(View view){
        try{
            rvAdapter=new RVAdapter(databaseHandler.getALLFARMPRODUCTImagesData());
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