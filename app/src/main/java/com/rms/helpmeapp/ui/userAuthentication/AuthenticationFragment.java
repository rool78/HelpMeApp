package com.rms.helpmeapp.ui.userAuthentication;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rms.helpmeapp.R;
import com.rms.helpmeapp.ui.userAuthentication.controllers.ControllerAuthentication;
import com.rms.helpmeapp.util.UserSingleton;

import java.util.Arrays;
import java.util.List;

public class AuthenticationFragment extends Fragment implements AuthenticationView{

    private ControllerAuthentication controller;

    public AuthenticationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Dependency Injection?
        controller = new ControllerAuthentication(view, this, this);
        controller.onViewCreated();
    }

    @Override
    public void onResume() {
        super.onResume();
        controller.onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        controller.onActicityResult(requestCode, resultCode);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}


