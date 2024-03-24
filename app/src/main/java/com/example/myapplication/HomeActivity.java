package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;
    private RecyclerView recyclerView;
    private RVAdapter rvAdapter;
    Button showImageBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        showImageBtn=findViewById(R.id.showImageBtn);

        showImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,EMarketRaw.class);
                startActivity(intent);
            }
        });
        /*try{
            recyclerView=findViewById(R.id.imagesRV);
            databaseHandler=new DatabaseHandler(this);
        }catch(Exception e){
            Toast.makeText(this, "e.getMessage", Toast.LENGTH_SHORT).show();
        }*/

        /*Buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,PaymentActivity.class);
                startActivity(intent);
                Toast.makeText(HomeActivity.this, "Buy successfully", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    /*public void getData(View view){
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

    }*/

    /*public void getProductData(View view){
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

    }*/
}