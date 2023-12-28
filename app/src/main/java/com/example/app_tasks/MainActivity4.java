package com.example.app_tasks;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ListView listv = findViewById(R.id.tachSuprimer);
      CostumTachAdapter costumTachAdapter = new CostumTachAdapter(this,CostumTachAdapter.tachesSuprimer);
//        costumTachAdapter.notifyDataSetChanged();
        listv.setAdapter(costumTachAdapter);
//      ArrayList<Tach> list = new ArrayList<>();

//        MainActivity2.listTach.add();

    }}