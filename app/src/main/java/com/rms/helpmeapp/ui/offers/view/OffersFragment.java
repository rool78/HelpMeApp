package com.rms.helpmeapp.ui.offers.view;


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
import com.rms.helpmeapp.ui.offers.controllers.OffersController;
import com.rms.helpmeapp.ui.offers.view.adapters.OfferAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OffersFragment extends Fragment {

    private RecyclerView recyclerView;
    private OfferAdapter adapter;
    private OffersController controller;

    public OffersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_offers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.adapter = new OfferAdapter(new ArrayList<Offer>());
        this.recyclerView = view.findViewById(R.id.recyclerView);
        this.controller = new OffersController(adapter, view);

        LinearLayoutManager linearLayoutManager = new GridLayoutManager(view.getContext(),
                    getResources().getInteger(R.integer.main_columns));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        controller.onCreatedView();

    }
}
