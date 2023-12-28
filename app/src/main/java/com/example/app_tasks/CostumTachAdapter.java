package com.example.app_tasks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public  class CostumTachAdapter extends BaseAdapter {
     Context context;
     List<Tach> tachList;

     Toast toast;
     public  static ArrayList<Tach> tachesSuprimer = new ArrayList<>();
    public CostumTachAdapter(Context context, List<Tach> tachList){
        this.tachList = tachList;
        this.context = context;
    }


    public List<Tach> getTachList() {
        return tachList;
    }

    public void setTachList(List<Tach> tachList) {
        this.tachList = tachList;
        this.notifyDataSetChanged();
    }

    public ArrayList<Tach> getTachListSuprimer() {
        return tachesSuprimer;
    }

    CostumTachAdapter con = this;

    @Override
    public int getCount() {
        return tachList.size();
    }

    @Override
    public Object getItem(int position) {
        return tachList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

          if (convertView == null){
             convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pg1,parent,false);
          }
        Tach tach = tachList.get(position);
        TextView  titleView = convertView.findViewById(R.id.title);
        TextView  descriptionView = convertView.findViewById(R.id.description);
        TextView  dateView = convertView.findViewById(R.id.date);
        ImageView imageView = convertView.findViewById(R.id.icon);
        ImageButton imgBtn = convertView.findViewById(R.id.imgBtn);
        CheckBox check = convertView.findViewById(R.id.check);
        titleView.setText(tach.getTitle());
        dateView.setText(tach.getDate().toString());
        descriptionView.setText(tach.getDescription().toString());
        switch (tach.getEtat()){
            case Urgent:
                imageView.setImageResource(R.drawable.alarm);
                break;
            case simple:
               imageView.setImageResource(R.drawable.faiblle);
                break;
            case Moyenne:
                imageView.setImageResource(R.drawable.moyenne);
                break;
            default:
                imageView.setImageResource(R.drawable.eye);
        }



        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {

//
                Toast t = Toast.makeText(context,"la tach "+tach.getTitle()+" a ete suprimer ",Toast.LENGTH_SHORT);
                t.show();

//                for (Tach x : tachList) {
//                    toast =  Toast.makeText(context, tachList.get(tachList.lastIndexOf(x)).getTitle(),Toast.LENGTH_SHORT);
//                }
//                toast.show();
                tachesSuprimer.add(tach);
                tachList.remove(tach);
                con.notifyDataSetChanged();


            }
        });

          return convertView;
    }


}
