package com.rms.helpmeapp.ui.detail;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rms.helpmeapp.R;
import com.rms.helpmeapp.model.Offer;
import com.rms.helpmeapp.ui.detail.controllers.DetailController;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements DetailView {

    private TextView tvTitle;
    private TextView tvDescription;
    private TextView tvTime;
    private TextView tvName;
    private TextView tvNumber;
    private TextView tvLocation;
    private Button btEdit;
    private Button btDelete;

    private DetailController controller;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        controller = new DetailController(this);

        this.tvTitle = view.findViewById(R.id.tvTitle);
        this.tvDescription = view.findViewById(R.id.tvDescription);
        this.tvTime = view.findViewById(R.id.tvTime);
        this.tvName = view.findViewById(R.id.tvUserName);
        this.tvLocation = view.findViewById(R.id.tvLocation);
        this.btEdit = view.findViewById(R.id.btEdit);
        this.btDelete = view.findViewById(R.id.btDelete);

        if (getArguments() != null) {
            controller.configOffer(getArguments());
        }

        this.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        this.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.deleteOffer();
            }
        });
    }

    public void showDetails(Offer offer, String name) {
        tvTitle.setText(offer.getTitle());
        tvDescription.setText(offer.getDescription());
        tvTime.setText(new Date(offer.getTime()).toString());
        tvName.setText(name);
        tvLocation.setText(offer.getCity() + ", " + offer.getProvince());
    }

    @Override
    public void showEditButtons() {
        btEdit.setVisibility(View.VISIBLE);
        btDelete.setVisibility(View.VISIBLE);
    }


}
