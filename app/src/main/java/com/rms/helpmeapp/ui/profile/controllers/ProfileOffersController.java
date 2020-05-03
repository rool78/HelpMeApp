package com.rms.helpmeapp.ui.profile.controllers;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.rms.helpmeapp.model.Offer;
import com.rms.helpmeapp.ui.profile.model.ProfileDbHelper;
import com.rms.helpmeapp.ui.profile.views.adapters.ProfileOffersAdapter;
import com.rms.helpmeapp.util.UserSingleton;

import java.util.ArrayList;
import java.util.List;

public class ProfileOffersController {

    private ProfileDbHelper db;
    private ProfileOffersAdapter adapter;
    private List<Offer> offers = new ArrayList<>();

    public ProfileOffersController(ProfileOffersAdapter adapter) {
        this.adapter = adapter;
        this.db = new ProfileDbHelper();
    }

    public void onViewCreated() {
        showOffers();
    }

    public void showOffers() {
        UserSingleton userSingleton = UserSingleton.getInstance();

        Task<DataSnapshot> task = db.findUserOffers(userSingleton.user.getId());
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
