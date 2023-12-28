package com.example.app_tasks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NonNls;

import java.util.List;

public class tachAdapter extends  RecyclerView.Adapter<tachAdapter.tachViewHolder> {
    private List<Tach> tachList;
    public tachAdapter(List<Tach> tachList){
        this.tachList = tachList;
    }

    @NonNull
    @Override
    public tachViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.pg1,parent,false);
       return new tachViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull tachViewHolder holder, int position) {
        Tach tach = tachList.get(position);
        holder.titleView.setText(tach.getTitle());
        holder.descriptionView.setText(tach.getDescription());
        holder.dateView.setText(tach.getDate().toString());
        switch (tach.getEtat()){
            case Urgent:
                holder.imageView.setImageResource(R.drawable.alarm);
                break;
            case EnCours:
                holder.imageView.setImageResource(R.drawable.eye);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return tachList.size();
    }

    public static class tachViewHolder extends RecyclerView.ViewHolder {
        TextView titleView,descriptionView,dateView;
        ImageView imageView;
        public tachViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.title);
            descriptionView = itemView.findViewById(R.id.description);
            dateView = itemView.findViewById(R.id.title);
        }
    }
}
