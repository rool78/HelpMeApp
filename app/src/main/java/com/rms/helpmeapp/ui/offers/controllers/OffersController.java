package com.rms.helpmeapp.ui.offers.controllers;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.rms.helpmeapp.R;
import com.rms.helpmeapp.dataAccess.FirebaseRealtimeDB;
import com.rms.helpmeapp.model.Offer;
import com.rms.helpmeapp.ui.offers.view.adapters.OfferAdapter;
import com.rms.helpmeapp.ui.offers.view.adapters.OnOfferClickListener;

import java.util.ArrayList;
import java.util.List;

public class OffersController implements OnOfferClickListener {

    private FirebaseRealtimeDB db;
    private OfferAdapter adapter;
    private View view;
    private List<Offer> offers = new ArrayList<>();

    public OffersController(OfferAdapter adapter, View view) {
        this.adapter = adapter;
        this.view = view;
        this.db = new FirebaseRealtimeDB();
    }

    public void onCreatedView() {
        adapter.setListener(this);
        showOffers();
    }

    public void showOffers() {
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

    @Override
    public void onOfferClick(Offer offer) {
        final NavController navController = Navigation.findNavController(view);
        Bundle arguments = new Bundle();
        arguments.putString(Offer.TITLE, offer.getTitle());
        arguments.putString(Offer.DESCRIPTION, offer.getDescription());
        arguments.putString(Offer.COUNTRY, offer.getCountry());
        arguments.putString(Offer.CITY, offer.getCity());
        arguments.putString(Offer.PROVINCE, offer.getProvince());
        arguments.putString(Offer.ADDRESS, offer.getAddress());
        navController.navigate(R.id.action_offersFragment_to_detailFragment, arguments);
    }
}

