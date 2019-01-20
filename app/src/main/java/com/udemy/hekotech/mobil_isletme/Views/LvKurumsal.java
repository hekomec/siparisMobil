package com.udemy.hekotech.mobil_isletme.Views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.udemy.hekotech.mobil_isletme.Classes.Iletisim;
import com.udemy.hekotech.mobil_isletme.Classes.Kurumsal;
import com.udemy.hekotech.mobil_isletme.R;

import java.util.List;

/**
 * Created by hekotech on 20.01.2019.
 */

public class LvKurumsal  extends RecyclerView.Adapter<LvKurumsal.MyViewHolder> {


    private List<Kurumsal> list;

    public LvKurumsal(List<Kurumsal> elist) {
        this.list = elist;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView name,message,date,exp;
        public Button sil_kurumsal;
        public MyViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.c_kurumsal_name);
            message = itemView.findViewById(R.id.c_kurumsal_message);
            date = itemView.findViewById(R.id.c_kurumsal_date);
            exp = itemView.findViewById(R.id.c_kurumsal_exp);
            sil_kurumsal = itemView.findViewById(R.id.c_kurumsal_sil);
        }


    }

    @NonNull
    @Override
    public LvKurumsal.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.c_kurumsal,parent,false);
        return new LvKurumsal.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LvKurumsal.MyViewHolder holder, int position) {
        final Kurumsal mylist = list.get(position);
        holder.name.setText(mylist.getName());
        holder.message.setText(mylist.getMessage());
        holder.exp.setText(mylist.getExp());
        holder.date.setText(mylist.getDate());
        holder.sil_kurumsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
