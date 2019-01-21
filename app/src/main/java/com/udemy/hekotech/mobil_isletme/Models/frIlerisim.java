package com.udemy.hekotech.mobil_isletme.Models;


import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.udemy.hekotech.mobil_isletme.Classes.Iletisim;
import com.udemy.hekotech.mobil_isletme.Classes.Siparis;
import com.udemy.hekotech.mobil_isletme.R;
import com.udemy.hekotech.mobil_isletme.Views.LvIletisim;
import com.udemy.hekotech.mobil_isletme.Views.LvSiparis;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by hekotech on 20.01.2019.
 */

public class frIlerisim  extends Fragment {

    FirebaseDatabase dbIletisim;
    DatabaseReference refIletisim;

    private List<Iletisim> list = new ArrayList<>();
    RecyclerView recyclerView;
    LvIletisim adapter;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstance){


        prepareData();

        View rootView = inflater.inflate(R.layout.r_iletisim,container,false);
        return rootView;



    }

    private void prepareData() {
        dbIletisim = FirebaseDatabase.getInstance();
        refIletisim = dbIletisim.getReference("iletisim");
        refIletisim.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Iletisim value = dataSnapshot1.getValue(Iletisim.class);
                    Iletisim fire = new Iletisim();
                    String date = value.getDate();
                    String many = value.getMany();
                    String name = value.getName();
                    String message = value.getMessage();

                    String id = dataSnapshot1.getKey();

                    fire.setName(name);
                    fire.setMany(many);
                    fire.setMessage(message);
                    fire.setDate(date);

                    list.add(fire);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "onCancelled: bişiler ters gitti");
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();

        recyclerView = getActivity().findViewById(R.id.Rw_iletisim);
        adapter = new LvIletisim(list);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getActivity().getApplicationContext(),
                        LinearLayout.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


    }


}
