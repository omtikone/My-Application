package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShopkeeperRegisterActivity extends AppCompatActivity {

    EditText username, password, cpassword,email;

    private Button btnsignin,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopkeeper_register);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        cpassword = (EditText) findViewById(R.id.cpassword);

        signup = (Button) findViewById(R.id.btnsignup);
        btnsignin= (Button) findViewById(R.id.btnsignin);
        DatabaseHandler DB = new DatabaseHandler(this);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ShopkeeperRegisterActivity.this,ShopkeeperLoginActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String email1 = email.getText().toString();
                String pass = password.getText().toString();
                String cpass = cpassword.getText().toString();

                if (user.equals("") ||email1.equals("") || pass.equals("") || cpass.equals(""))

                    Toast.makeText(ShopkeeperRegisterActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(cpass)){
                        Boolean checkshopkeeper = DB.checkshopkeepername(user);
                        if(checkshopkeeper==false){
                            Boolean insert = DB.insertShopkeeper(user,email1, pass,cpass);
                            if(insert==true){
                                Toast.makeText(ShopkeeperRegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ShopkeeperRegisterActivity.this,ShopkeeperLoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(ShopkeeperRegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(ShopkeeperRegisterActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(ShopkeeperRegisterActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}