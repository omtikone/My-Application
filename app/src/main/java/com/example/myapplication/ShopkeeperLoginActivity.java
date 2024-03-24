package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShopkeeperLoginActivity extends AppCompatActivity {

    private Button btnsignup,btnlogin;
    EditText username, password;
    DatabaseHandler DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopkeeper_login);

        username = (EditText) findViewById(R.id.username5);
        password = (EditText) findViewById(R.id.password5);
        btnlogin = (Button) findViewById(R.id.btnsignin5);
        btnsignup=findViewById(R.id.btnsignup5);

        DatabaseHandler DB = new DatabaseHandler(this);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ShopkeeperLoginActivity.this,ShopkeeperRegisterActivity.class);
                startActivity(intent);
            }
        });

       btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(ShopkeeperLoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkshopkeepernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(ShopkeeperLoginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), ShopkeeperHomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(ShopkeeperLoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}