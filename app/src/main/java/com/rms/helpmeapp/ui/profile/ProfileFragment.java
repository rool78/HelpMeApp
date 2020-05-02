package com.rms.helpmeapp.ui.profile;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rms.helpmeapp.R;
import com.rms.helpmeapp.model.User;
import com.rms.helpmeapp.ui.profile.controllers.ProfileController;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements ProfileView {

    private ProfileController controller;
    private TextView tvName;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvName = view.findViewById(R.id.tvUserName);
        controller.onViewCreated();

    }

    @Override
    public void showUserData(User user) {
        tvName.setText(user.getName());
    }
}
