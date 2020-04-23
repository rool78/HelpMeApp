package com.rms.helpmeapp.ui.detail;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rms.helpmeapp.R;
import com.rms.helpmeapp.model.Offer;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private TextView tvTitle;
    private TextView tvDescription;
    private TextView tvName;

    private Offer offer;

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

        this.tvTitle = view.findViewById(R.id.tvTitle);
        this.tvDescription = view.findViewById(R.id.tvDescription);
        this.tvName = view.findViewById(R.id.tvUserName);

        if (getArguments() != null) {
            configOffer(getArguments());
            tvTitle.setText(offer.getTitle());
            tvDescription.setText(offer.getDescription());
        }
    }

    public void configOffer(Bundle args) {
        offer = new Offer();
        offer.setTitle(args.getString(Offer.TITLE));
        offer.setDescription(args.getString(Offer.DESCRIPTION));
    }
}
