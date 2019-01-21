package com.udemy.hekotech.mobil_isletme.Views;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.udemy.hekotech.mobil_isletme.Classes.Iletisim;
import com.udemy.hekotech.mobil_isletme.Classes.Siparis;
import com.udemy.hekotech.mobil_isletme.R;

import java.util.List;

/**
 * Created by hekotech on 20.01.2019.
 */

public class LvIletisim extends RecyclerView.Adapter<LvIletisim.MyViewHolder> {

    FirebaseDatabase dbiletisim;
    DatabaseReference refIletisim;

private List<Iletisim> list;

    public LvIletisim(List<Iletisim> liste) {
        this.list=liste;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView name,message,date,many,number;
    public Button sil_iletisim,ara_iletisim;
    public MyViewHolder(View itemView){
        super(itemView);
        name = itemView.findViewById(R.id.c_iletisim_name);
        message = itemView.findViewById(R.id.c_iletisim_message);
        date = itemView.findViewById(R.id.c_iletisim_date);
        many = itemView.findViewById(R.id.c_iletisim_many);
        sil_iletisim = itemView.findViewById(R.id.c_iletisim_sil);
        ara_iletisim=itemView.findViewById(R.id.c_iletisim_ara);
        number = itemView.findViewById(R.id.c_iletisim_number);
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
        holder.number.setText(mylist.getNumber());
        holder.sil_iletisim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbiletisim = FirebaseDatabase.getInstance();
                refIletisim = dbiletisim.getReference("iletisim");
                refIletisim.child(mylist.getId()).removeValue();
            }
        });
        holder.ara_iletisim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:"+mylist.getNumber()));
                view.getContext().startActivity(call);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
