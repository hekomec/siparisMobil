package com.udemy.hekotech.mobil_isletme.Models;

import android.app.Fragment;
import android.os.Bundle;
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
import com.udemy.hekotech.mobil_isletme.Classes.Siparis;
import com.udemy.hekotech.mobil_isletme.R;
import com.udemy.hekotech.mobil_isletme.Views.LvSiparis;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by hekotech on 20.01.2019.
 */

public class FrSiparis extends Fragment {

    FirebaseDatabase dbSiparis;
    DatabaseReference refSiparis;

    private List<Siparis> list = new ArrayList<>();
    RecyclerView recyclerView;
    LvSiparis adapter;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstance){


        prepareData();

        View rootView = inflater.inflate(R.layout.r_siparis,container,false);
        return rootView;



    }

    private void prepareData() {
        dbSiparis = FirebaseDatabase.getInstance();
        refSiparis = dbSiparis.getReference("siparis");
        refSiparis.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Siparis value = dataSnapshot1.getValue(Siparis.class);
                    Siparis fire = new Siparis();

                    String order = value.getOrder();
                    String total = value.getTotal();
                    String id = dataSnapshot1.getKey();

                    fire.setOrder(order);
                    fire.setTotal(total);

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

        recyclerView = getActivity().findViewById(R.id.Rw_siparis);
        adapter = new LvSiparis(list);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getActivity().getApplicationContext(),
                        LinearLayout.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


    }


}
