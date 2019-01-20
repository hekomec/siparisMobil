package com.udemy.hekotech.mobil_isletme.Views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.udemy.hekotech.mobil_isletme.Classes.Siparis;
import com.udemy.hekotech.mobil_isletme.R;

import java.util.List;

/**
 * Created by hekotech on 20.01.2019.
 */

public class LvSiparis extends RecyclerView.Adapter<LvSiparis.MyViewHolder> {


    private List<Siparis> list;

    public LvSiparis(List<Siparis> elist) {
        this.list = elist;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView order,total;
        public Button sil_siparis;
        public MyViewHolder(View itemView){
            super(itemView);
            order = itemView.findViewById(R.id.c_siparis_order);
            total = itemView.findViewById(R.id.c_siparis_total);
            sil_siparis = itemView.findViewById(R.id.c_siparis_sil);
        }


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.c_siparis,parent,false);
        return new LvSiparis.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Siparis mylist = list.get(position);
        holder.order.setText(mylist.getOrder());
        holder.total.setText(mylist.getTotal());
        holder.sil_siparis.setOnClickListener(new View.OnClickListener() {
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
