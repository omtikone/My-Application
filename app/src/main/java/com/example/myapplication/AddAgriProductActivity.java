package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class AddAgriProductActivity extends AppCompatActivity {


    private EditText imageDetailsET,price,quantity;
    private ImageView objectimageview;
    private static final int PICK_IMAGE_REQUEST=100;
    private Uri imageFilePath;
    private Bitmap imageTostore;
    DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_agri_product);

        try{

            imageDetailsET=findViewById(R.id.rawMaterialNameET);
            objectimageview=findViewById(R.id.image);
            price=findViewById(R.id.priceET);
            quantity=findViewById(R.id.quantityET);
            databaseHandler=new DatabaseHandler(this);
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void chooseImage(View objectView){
        try {
            Intent objectIntent=new Intent();
            objectIntent.setType("image/*");

            objectIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(objectIntent,PICK_IMAGE_REQUEST);
        }catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, @NonNull Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data.getData() != null) {
                imageFilePath = data.getData();
                imageTostore = MediaStore.Images.Media.getBitmap(getContentResolver(), imageFilePath);
                objectimageview.setImageBitmap(imageTostore);
            }
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
        public void storeImage(View view){
            try {
                if(!imageDetailsET.getText().toString().isEmpty() && objectimageview.getDrawable()!=null && !price.getText().toString().isEmpty() && !quantity.getText().toString().isEmpty()&& imageTostore!=null)
                {
                    databaseHandler.storeImage(new AddRawMaterialDetails(imageDetailsET.getText().toString(),price.getText().toString(),quantity.getText().toString(),imageTostore));
                }else{
                    Toast.makeText(this, "Please fill above fields", Toast.LENGTH_SHORT).show();
            }
            }catch (Exception e)
            {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        public void moveToShowActivity(View view){
            startActivity(new Intent(this,ViewRawMaterialActivity.class));
        }
    }

