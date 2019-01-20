package com.udemy.hekotech.mobil_isletme.Views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.udemy.hekotech.mobil_isletme.Classes.Iletisim;
import com.udemy.hekotech.mobil_isletme.Classes.Siparis;
import com.udemy.hekotech.mobil_isletme.R;

import java.util.List;

/**
 * Created by hekotech on 20.01.2019.
 */

public class LvIletisim extends RecyclerView.Adapter<LvIletisim.MyViewHolder> {


private List<Iletisim> list;

    public LvIletisim(List<Iletisim> liste) {
        this.list=liste;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView name,message,date,many;
    public Button sil_iletisim;
    public MyViewHolder(View itemView){
        super(itemView);
        name = itemView.findViewById(R.id.c_iletisim_name);
        message = itemView.findViewById(R.id.c_iletisim_message);
        date = itemView.findViewById(R.id.c_iletisim_date);
        many = itemView.findViewById(R.id.c_iletisim_many);
        sil_iletisim = itemView.findViewById(R.id.c_iletisim_sil);
    }


}

    @NonNull
    @Override
    public LvIletisim.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.c_iletisim,parent,false);
        return new LvIletisim.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LvIletisim.MyViewHolder holder, int position) {
        final Iletisim mylist = list.get(position);
        holder.name.setText(mylist.getName());
        holder.message.setText(mylist.getMessage());
        holder.many.setText(mylist.getMany());
        holder.date.setText(mylist.getDate());
        holder.sil_iletisim.setOnClickListener(new View.OnClickListener() {
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
