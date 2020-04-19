package com.rms.helpmeapp.ui.userAuthentication.controllers;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.firebase.auth.FirebaseUser;
import com.rms.helpmeapp.R;
import com.rms.helpmeapp.util.UserSingleton;

public class ControllerAuthentication {

    private View view;

    public ControllerAuthentication(View view){
        this.view = view;
    }

    public void authenticationSucced(FirebaseUser firebaseUser){
        final NavController navController = Navigation.findNavController(view);

        UserSingleton userSingleton = UserSingleton.getInstance();

        userSingleton.user.setAuthId(firebaseUser.getUid());
        userSingleton.user.setName(firebaseUser.getDisplayName());

        Log.d("@@##--", "FirebaseUser, Name: " + firebaseUser.getDisplayName() + " AuthId: " + firebaseUser.getUid());

        navController.navigate(R.id.action_loginFragment_to_formFragment);

    }
}
