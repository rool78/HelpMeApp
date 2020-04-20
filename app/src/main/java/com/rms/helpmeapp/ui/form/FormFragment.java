package com.rms.helpmeapp.ui.form;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.rms.helpmeapp.R;
import com.rms.helpmeapp.model.Offer;
import com.rms.helpmeapp.ui.form.controllers.FormController;
import com.rms.helpmeapp.util.UserSingleton;

public class FormFragment extends Fragment implements FormView {

    private TextInputLayout tilTitle;
    private TextInputLayout tilDescription;
    private TextInputLayout tilCountry;
    private TextInputLayout tilProvince;
    private TextInputLayout tilCity;
    private TextInputLayout tilAddress;
    private Button btSave;

    private FormController controller;

    public FormFragment() {
        //TODO inyectar dependencia controller
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        UserSingleton s = UserSingleton.getInstance();

        //Log.d("@@##--", s.user.toString());

        controller = new FormController(view);

        btSave = view.findViewById(R.id.btSave);
        tilTitle = view.findViewById(R.id.tilTitle);
        tilDescription = view.findViewById(R.id.tilDescription);
        tilCountry = view.findViewById(R.id.tilCountry);
        tilProvince = view.findViewById(R.id.tilProvince);
        tilCity = view.findViewById(R.id.tilCity);
        tilAddress = view.findViewById(R.id.tilAddress);


        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = tilTitle.getEditText().getText().toString();
                String description = tilDescription.getEditText().getText().toString();
                String country = tilCountry.getEditText().getText().toString();
                String province = tilProvince.getEditText().getText().toString();
                String city = tilCity.getEditText().getText().toString();
                String address = tilAddress.getEditText().getText().toString();

                Offer offer = new Offer(title, description, country, city, province, address, 1);
                Log.d("@@##--","FormView: Save button pressed " + offer);

                controller.submitOffer(offer);
            }
        });
    }
}
