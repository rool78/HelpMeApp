package com.rms.helpmeapp.ui.form.controllers;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.rms.helpmeapp.R;
import com.rms.helpmeapp.dataAccess.FirebaseRealtimeDB;
import com.rms.helpmeapp.model.Offer;
import com.rms.helpmeapp.util.UserSingleton;

public class FormController {

    private View view;
    private FirebaseRealtimeDB db;

    public FormController(View view){
        this.view = view;
        this.db = new FirebaseRealtimeDB();
    }

    public void submitOffer(Offer offer){
        //final NavController navController = Navigation.findNavController(view);
        //navController.navigate(R.id.action_loginFragment_to_formFragment);
        UserSingleton user = UserSingleton.getInstance();
        db.addOffer(user.user.getId(), offer);
    }

    public boolean validateOffer(Offer offer){
        return false;
    }

    public void navigateToDetail(){

    }



}
