package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewRawMaterialActivity extends AppCompatActivity{

    private DatabaseHandler databaseHandler;
    private RecyclerView recyclerView;
    private RVAdapter rvAdapter;


    Button btn_addToCart;
    ArrayList<AddRawMaterialDetails> addRawMaterialDetailsArrayList;

    Button btn_buy;
    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_raw_material);

      /*  btn_buy=findViewById(R.id.btn_buy);*/
        try{
            recyclerView=findViewById(R.id.imagesRV);
            databaseHandler=new DatabaseHandler(this);
        }catch(Exception e){
            Toast.makeText(this, "e.getMessage", Toast.LENGTH_SHORT).show();
        }

       /* btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ViewRawMaterialActivity.this, "buy successfully", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    public void getData(View view){
        try{
            rvAdapter=new RVAdapter(databaseHandler.getALLImagesData(),this);
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


