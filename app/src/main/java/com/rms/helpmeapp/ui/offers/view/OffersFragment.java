package com.rms.helpmeapp.ui.offers.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rms.helpmeapp.R;
import com.rms.helpmeapp.ui.offers.view.adapters.OfferAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OffersFragment extends Fragment {

    private OfferAdapter offerAdapter;
    private RecyclerView mRecyclerView;

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

        this.mRecyclerView = view.findViewById(R.id.recyclerView);

        List<String> prueba = new ArrayList<>();
        prueba.add("aaa");
        prueba.add("bbb");

        offerAdapter = new OfferAdapter(prueba);

        LinearLayoutManager linearLayoutManager = new GridLayoutManager(view.getContext(),
                    getResources().getInteger(R.integer.main_columns));
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(offerAdapter);

    }
}
