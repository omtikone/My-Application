package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class single_row extends AppCompatActivity {

    Button btn_addToCart;
    private DatabaseHandler databaseHandler;
    private RecyclerView recyclerView;

    ArrayList<AddRawMaterialDetails> addRawMaterialDetailsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_row);

       /* btn_addToCart=findViewById(R.id.btn_addToCart);*/
        /*btn_buy=findViewById(R.id.btn_buy);

        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(single_row.this,PaymentActivity.class);
                startActivity(intent);
                Toast.makeText(single_row.this, "Buy product successfully", Toast.LENGTH_SHORT).show();
            }
        });*/
        /*btn_addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

      /*  try{
            recyclerView=findViewById(R.id.imagesRVV);
            databaseHandler=new DatabaseHandler(this);
        }catch(Exception e){
            Toast.makeText(this, "e.getMessage", Toast.LENGTH_SHORT).show();
        }*/
    }


    /*public void getProductData(View view){
        try{
            rvsingleadapter=new rvsingleAdapter(databaseHandler.getsingleProductImagesData(),this);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(rvsingleadapter);
        }
        catch(Exception e)
        {
            Toast.makeText(this, "e.getMessage", Toast.LENGTH_SHORT).show();
        }


    }*/
    }
