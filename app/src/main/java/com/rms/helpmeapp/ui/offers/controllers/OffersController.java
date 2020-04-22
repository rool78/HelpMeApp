package com.rms.helpmeapp.ui.offers.controllers;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.rms.helpmeapp.dataAccess.FirebaseRealtimeDB;
import com.rms.helpmeapp.model.Offer;
import com.rms.helpmeapp.ui.offers.view.adapters.OfferAdapter;

import java.util.ArrayList;
import java.util.List;

public class OffersController {

    private FirebaseRealtimeDB db;
    private OfferAdapter adapter;
    private List<Offer> offers = new ArrayList<>();

    public OffersController(OfferAdapter adapter) {
        this.adapter = adapter;
        this.db = new FirebaseRealtimeDB();
    }

    public void onCreatedView() {
        //Fixme findAllOffers se queda siempre a la escucha
        Task<DataSnapshot> task = db.findAllOffers();

        task.addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    for (DataSnapshot child : task.getResult().getChildren()) {
                        Offer offer = child.getValue(Offer.class);
                        if (offer != null) {
                            Log.d("@@##--", "Offer find " + offer.toString());
                            offers.add(offer);
                        }
                    }
                    adapter.setOffers(offers);
                    adapter.notifyDataSetChanged();
                }
            }
        });


    }
}

