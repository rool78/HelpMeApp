package com.rms.helpmeapp.ui.profile.views;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rms.helpmeapp.R;
import com.rms.helpmeapp.model.Offer;
import com.rms.helpmeapp.ui.profile.controllers.ProfileOffersController;
import com.rms.helpmeapp.ui.profile.views.adapters.ProfileOffersAdapter;

import java.util.ArrayList;

public class ProfileOffersFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProfileOffersAdapter adapter;
    private ProfileOffersController controller;

    public ProfileOffersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_offers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.adapter = new ProfileOffersAdapter(new ArrayList<Offer>());
        this.controller = new ProfileOffersController(adapter);
        this.recyclerView = view.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new GridLayoutManager(view.getContext(),
                getResources().getInteger(R.integer.main_columns));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        controller.onViewCreated();

    }
}
