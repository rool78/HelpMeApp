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

public class AuthenticationFragment extends Fragment {

    private static final int RC_SIGN_IN = 123;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private ControllerAuthentication controller;

    public AuthenticationFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Dependency Injection?
        controller = new ControllerAuthentication(view);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    controller.authenticationSucced(firebaseUser);
                } else {
                    List<AuthUI.IdpConfig> providers = Arrays.asList(
                                new AuthUI.IdpConfig.EmailBuilder().build(),
                                new AuthUI.IdpConfig.GoogleBuilder().build());


                    startActivityForResult(AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setTosAndPrivacyPolicyUrls("", "")
                                .setAvailableProviders(providers)
                                .build(), RC_SIGN_IN);
                }
            }
        };

    }

    @Override
    public void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == -1) {
                // Successfully signed in
                //TODO habria que mirar te contruir el objeto userSingleton bien en este punto para ya tenerlo listo
                Toast.makeText(getContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
                Toast.makeText(getContext(), "Algo fallo ", Toast.LENGTH_SHORT).show();
            }
        }
    }
}


