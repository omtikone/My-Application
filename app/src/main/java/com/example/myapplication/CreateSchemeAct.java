package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateSchemeAct extends AppCompatActivity {

    EditText schemename1,schemenidhi1,duration1;
    private Button apply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_scheme);

        SchemeDetails schemeDetails=new SchemeDetails(this);
        schemename1 = (EditText) findViewById(R.id.schemename);
        schemenidhi1 = (EditText) findViewById(R.id.schemenidhi);
        duration1 = (EditText) findViewById(R.id.duration);
        apply = (Button) findViewById(R.id.apply);

        DatabaseHandler DB = new DatabaseHandler(this);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String schemename = schemename1.getText().toString();
                String schemenidhi = schemenidhi1.getText().toString();
                String duration = duration1.getText().toString();



                if (schemename.equals("") ||schemenidhi.equals("") || duration.equals(""))
                    Toast.makeText(CreateSchemeAct.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean insert = DB.insertScheme(schemename,schemenidhi,duration);
                    if(insert==true){
                        Toast.makeText(CreateSchemeAct.this, "Scheme added successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CreateSchemeAct.this,AdminHomeActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(CreateSchemeAct.this, "Scheme not added", Toast.LENGTH_SHORT).show();
                    }}
            }
        });


    }
}