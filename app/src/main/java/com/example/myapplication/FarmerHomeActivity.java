package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FarmerHomeActivity extends AppCompatActivity {

    private Button governmentscheme,aggriproduct,showImage1Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_home);

        governmentscheme = (Button) findViewById(R.id.governmentscheme);
        aggriproduct = (Button) findViewById(R.id.aggriproduct);
        showImage1Btn = (Button) findViewById(R.id.showImage1Btn);

        governmentscheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FarmerHomeActivity.this,ViewScheme.class);
                startActivity(intent);
            }
        });

        aggriproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FarmerHomeActivity.this,AddAgriProductActivity.class);
                startActivity(intent);
            }
        });

        showImage1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FarmerHomeActivity.this,EmarketFarmProduct.class);
                startActivity(intent);
            }
        });
    }


}