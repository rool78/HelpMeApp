package com.rms.helpmeapp.ui.profile.controllers;

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
import com.rms.helpmeapp.model.Offer;
import com.rms.helpmeapp.ui.profile.model.ProfileDbHelper;
import com.rms.helpmeapp.ui.profile.views.adapters.OnOfferClickListener;
import com.rms.helpmeapp.ui.profile.views.adapters.ProfileOffersAdapter;
import com.rms.helpmeapp.util.UserSingleton;

import java.util.ArrayList;
import java.util.List;

public class ProfileOffersController implements OnOfferClickListener {

    private ProfileDbHelper db;
    private ProfileOffersAdapter adapter;
    private View view;
    private List<Offer> offers = new ArrayList<>();

    public ProfileOffersController(ProfileOffersAdapter adapter, View view) {
        this.adapter = adapter;
        this.view = view;
        this.db = new ProfileDbHelper();
    }

    public void onViewCreated() {
        adapter.setListener(this);
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

    @Override
    public void onOfferClick(Offer offer) {
        final NavController navController = Navigation.findNavController(view);
        Bundle arguments = new Bundle();
        arguments.putString(Offer.ID, offer.getId());
        arguments.putString(Offer.TITLE, offer.getTitle());
        arguments.putString(Offer.DESCRIPTION, offer.getDescription());
        arguments.putString(Offer.COUNTRY, offer.getCountry());
        arguments.putString(Offer.CITY, offer.getCity());
        arguments.putString(Offer.PROVINCE, offer.getProvince());
        arguments.putString(Offer.ADDRESS, offer.getAddress());
        arguments.putString(Offer.USER_ID, offer.getUserId());
        arguments.putBoolean("profile", true);

        navController.navigate(R.id.action_profileOffersFragment_to_detailFragment, arguments);
    }
}
