package com.example.app_tasks;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity3 extends AppCompatActivity {
     Etat etat;
     Spinner EtatSpinner;
     List<String> etatList = new ArrayList<>(
             List.of(
                     "ENCOURE",
                     "URGENT",
                     "MOYENNE",
                     "SIMPLE"
             )
     );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_page3);
        //
        EditText title = findViewById(R.id.title);
        EditText description = findViewById(R.id.description);
        EditText date = findViewById(R.id.date);
        Button btn = findViewById(R.id.btn);
        EtatSpinner = findViewById(R.id.EtatSpinner);
        // spinner Adapter
        ArrayAdapter spinnerAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,etatList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        EtatSpinner.setAdapter(spinnerAdapter);
        // recupere les donnee de spinner pour l'etat ;
  EtatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
          String etatSpiner = parent.getItemAtPosition(position).toString();
           switch (etatSpiner){
               case "URGENT" :
                   etat = Etat.Urgent;
                   break;
               case "MOYENNE" :
                   etat = Etat.Moyenne;
                   break;
               case "SIMPLE" :
                   etat = Etat.simple;
                   break;
               default:
                   etat = Etat.EnCours;

           }
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
  });
        // btnAjoute : ajouter un tach a la list principale ;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
               Tach tach = new Tach(
                       title.getText().toString(),
                       description.getText().toString(),
                       etat,
                       date.getText().toString()
               );

               Data.listTach.add(tach);
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
               startActivity(intent);

            }
        });


    }}