package com.rms.helpmeapp.ui.form.controllers;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.rms.helpmeapp.R;
import com.rms.helpmeapp.model.Offer;

public class FormController {

    private View view;

    public FormController(View view){
        this.view = view;
    }

    public void submitOffer(Offer offer){

        final NavController navController = Navigation.findNavController(view);

        //Toast.makeText(view.getContext(), "Probando view + controller", Toast.LENGTH_LONG).show();

        navController.navigate(R.id.action_loginFragment_to_formFragment);

    }

    public boolean validateOffer(Offer offer){
        return false;
    }

    public void navigateToDetail(){

    }



}
