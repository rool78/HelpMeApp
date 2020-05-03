package com.rms.helpmeapp.ui.profile.views;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.rms.helpmeapp.R;
import com.rms.helpmeapp.model.User;
import com.rms.helpmeapp.ui.profile.controllers.ProfileController;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements ProfileView {

    private ProfileController controller;
    private TextView tvName;
    private Button btOffers;

    public ProfileFragment() {
        this.controller = new ProfileController(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        this.tvName = view.findViewById(R.id.tvUserName);
        this.btOffers = view.findViewById(R.id.btHelpOffers);
        this.controller.onViewCreated();

        btOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_profileFragment_to_profileOffersFragment);
            }
        });

    }

    @Override
    public void showUserData(User user) {
        tvName.setText(user.getName());
    }
}
