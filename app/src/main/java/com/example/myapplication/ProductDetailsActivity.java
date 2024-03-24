package com.example.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/*
public class ProductDetailsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{
*/
public class ProductDetailsActivity extends AppCompatActivity {


    TextView quantitynumber,priceitem,itemname,sr_imageDetailsTV;
    Button addToCart;
    /*ImageView image;*/
    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    Button addtoCart;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;
    ImageView imgcart;
    private DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        itemname=findViewById(R.id.sr_imageDetailsTV);
        addToCart=findViewById(R.id.addToCart);
        /*imageView = findViewById(R.id.image);*/
        plusquantity = findViewById(R.id.addquantity);
        minusquantity  = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        priceitem = findViewById(R.id.sr_priceTV);

        try{
            imageView=findViewById(R.id.image);
            itemname=findViewById(R.id.sr_imageDetailsTV);
            priceitem = findViewById(R.id.sr_priceTV);
            databaseHandler=new DatabaseHandler(this);
        }catch(Exception e){
            Toast.makeText(this, "e.getMessage", Toast.LENGTH_SHORT).show();
        }



        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // coffee price
                int basePrice = 5;
                quantity++;
                displayQuantity();
                int coffePrice = basePrice * quantity;
                String setnewPrice = String.valueOf(coffePrice);
                priceitem.setText(setnewPrice);

            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 5;
                // because we dont want the quantity go less than 0
                if (quantity == 0) {
                    Toast.makeText(ProductDetailsActivity.this, "Cant decrease quantity < 0", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    int coffePrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(coffePrice);
                    priceitem.setText(setnewPrice);

                }
            }
        });

        /*addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailsActivity.this, SummaryActivity.class);
                startActivity(intent);
                // once this button is clicked we want to save our values in the database and send those values
                // right away to summary activity where we display the order info

               *//* SaveCart();*//*
            }
        });*/

        imgcart=(ImageView)findViewById(R.id.imgcart);
        imgcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHandler db=new DatabaseHandler(ProductDetailsActivity.this);
            }
        });

    }

    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }




}