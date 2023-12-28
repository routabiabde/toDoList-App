package com.example.app_tasks;

import android.content.Context;
import android.content.Intent;
import android.media.RouteListingPreference;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainActivity2 extends AppCompatActivity {
      private  RecyclerView recyclerView;
      private  Toast toast;

      private CostumTachAdapter costumTachAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);
        Context con = this;

        ListView  listV = (ListView) findViewById(R.id.listV) ;

        ImageButton add = findViewById(R.id.add);

        Toolbar menu = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(menu);

          costumTachAdapter = new CostumTachAdapter((Context) this,Data.listTach);


        costumTachAdapter.notifyDataSetChanged();
        listV.setAdapter(costumTachAdapter);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                Intent i = new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.addMenu){
            Intent i = new Intent(getApplicationContext(),MainActivity3.class);
            startActivity(i);
            return true;
        } else if (itemId == R.id.tachSuprimerList) {
            Intent i = new Intent(getApplicationContext(),MainActivity4.class);
            startActivity(i);
            return true;
        }
        else if (itemId == R.id.sortedByName) {
            List<Tach> sortedList = Data.listTach.stream()
                    .sorted(Comparator.comparing(Tach::getTitle))
                    .collect(Collectors.toList());
            costumTachAdapter.setTachList(sortedList);
        } else if (itemId == R.id.sortedByEtateUrgent) {
            List<Tach> listFiltrerByTach = new ArrayList<>();
            for (Tach i:Data.listTach){
                 if (i.getEtat().equals(Etat.Urgent)){
                     listFiltrerByTach.add(i);
                 }
            }
            costumTachAdapter.setTachList(listFiltrerByTach);
        } else if (itemId == R.id.sortedByNormal) {
            costumTachAdapter.setTachList(Data.listTach);
        } else if (itemId == R.id.tachSuprimerList) {
            Toast.makeText(this,"option Add",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu,menu);
    return true;
}


}

