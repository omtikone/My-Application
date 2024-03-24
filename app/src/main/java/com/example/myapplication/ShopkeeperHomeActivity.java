package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ShopkeeperHomeActivity extends AppCompatActivity {

    /*private DatabaseHandler databaseHandler;
    private RecyclerView recyclerView;
    private RVAdapter rvAdapter;*/

    private Button aggriproductFarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopkeeper_home);

        aggriproductFarm = (Button) findViewById(R.id.aggriproductFarm);

        aggriproductFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ShopkeeperHomeActivity.this,AddAgriProductFarmActivity.class);
                startActivity(intent);
            }
        });
        /*try{
            recyclerView=findViewById(R.id.imagesRV);
            databaseHandler=new DatabaseHandler(this);
        }catch(Exception e){
            Toast.makeText(this, "e.getMessage", Toast.LENGTH_SHORT).show();
        }*/


    }


/*
    public void getFarmProductsData(View view){
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
}