package com.example.app_tasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText email = (EditText) findViewById(R.id.email);
        EditText pass = (EditText) findViewById(R.id.password);
        Button btn = (Button) findViewById(R.id.btn1);
        Toast toast = Toast.makeText(  this, "404",  Toast.LENGTH_SHORT);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                if (pass.getText().toString().length() <= 8 ){
                    toast.show();
                }
                else {
                    Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                 startActivity(i);
                }
            }
        });
    }
}