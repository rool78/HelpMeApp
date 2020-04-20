package com.rms.helpmeapp.ui.userAuthentication.controllers;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rms.helpmeapp.R;
import com.rms.helpmeapp.ui.userAuthentication.AuthenticationView;
import com.rms.helpmeapp.util.UserSingleton;

import java.util.Arrays;
import java.util.List;

public class ControllerAuthentication {

    private static final int RC_SIGN_IN = 123;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private AuthenticationView authenticationView;
    private View view;
    private Fragment fragment;

    public ControllerAuthentication(View view, Fragment fragment, AuthenticationView authenticationView){
        this.view = view;
        this.fragment = fragment;
        this.authenticationView = authenticationView;
    }

    public void onViewCreated(){
        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    validateUser(firebaseUser);
                } else {
                    List<AuthUI.IdpConfig> providers = Arrays.asList(
                            new AuthUI.IdpConfig.EmailBuilder().build(),
                            new AuthUI.IdpConfig.GoogleBuilder().build());


                    fragment.startActivityForResult(AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setTosAndPrivacyPolicyUrls("", "")
                            .setAvailableProviders(providers)
                            .build(), RC_SIGN_IN);
                }
            }
        };
    }

    public void validateUser(FirebaseUser firebaseUser){
        final NavController navController = Navigation.findNavController(view);

        UserSingleton userSingleton = UserSingleton.getInstance();

        userSingleton.user.setAuthId(firebaseUser.getUid());
        userSingleton.user.setName(firebaseUser.getDisplayName());

        Log.d("@@##--", "FirebaseUser, Name: " + firebaseUser.getDisplayName() + " AuthId: " + firebaseUser.getUid());

        navController.navigate(R.id.action_loginFragment_to_formFragment);
    }

    public void onResume(){
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    public void onActicityResult(int requestCode, int resultCode){
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == -1) {
                // Successfully signed in
                //authenticationView.showToast("BIENVENIDO");
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
                authenticationView.showToast("ALGO FALLO");
            }
        }
    }
}
