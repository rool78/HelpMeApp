package com.rms.helpmeapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.rms.helpmeapp.R;

public class HomeFragment extends Fragment {

    //private HomeViewModel homeViewModel;
    private Button btNeedHelp;
    private Button btWantToHelp;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        btNeedHelp = view.findViewById(R.id.btNeedHelp);
        btWantToHelp = view.findViewById(R.id.btWantToHelp);

        btNeedHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_home_to_helpFilterFragment);
            }
        });

        btWantToHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Si estamos autenticados vamos al formulario, si no a Sign in
                navController.navigate(R.id.action_nav_home_to_loginFragment);
            }
        });

    }
}