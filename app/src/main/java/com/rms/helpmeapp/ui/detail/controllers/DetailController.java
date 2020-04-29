package com.rms.helpmeapp.ui.detail.controllers;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.rms.helpmeapp.dataAccess.FirebaseRealtimeDB;
import com.rms.helpmeapp.model.Offer;
import com.rms.helpmeapp.ui.detail.DetailView;

public class DetailController {

    private DetailView detailView;
    private Offer offer;
    private FirebaseRealtimeDB db;

    public DetailController(DetailView detailView) {
        offer = new Offer();
        this.db = new FirebaseRealtimeDB();
        this.detailView = detailView;
    }

    public void configOffer(Bundle args) {

        offer.setTitle(args.getString(Offer.TITLE));
        offer.setDescription(args.getString(Offer.DESCRIPTION));
        offer.setTime(args.getLong(offer.TIME));
        offer.setUserId(args.getString(Offer.USER_ID));
        offer.setCountry(args.getString(Offer.COUNTRY));
        offer.setCity(args.getString(Offer.CITY));
        offer.setProvince(args.getString(Offer.PROVINCE));
        offer.setAddress(args.getString(Offer.ADDRESS));

        Task<DataSnapshot> task = db.findUserById(offer.getUserId());
        task.addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    for (DataSnapshot child : task.getResult().getChildren()) {
                        //FIXME por que no aparece el campo photoUrl
                        if (child.getKey().equals("name")) {
                            String name = child.getValue(String.class);
                            if (name != null) {
                                Log.d("@@##--", "Offer find " + name);
                                detailView.showDetails(offer, name);
                            }
                        }
                    }
                }
            }
        });
    }
}
