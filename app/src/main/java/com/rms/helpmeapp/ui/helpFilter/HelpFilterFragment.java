package com.rms.helpmeapp.ui.helpFilter;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rms.helpmeapp.MainActivity;
import com.rms.helpmeapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HelpFilterFragment extends Fragment {

    private Button btSearch;

    public HelpFilterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help_filter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        this.btSearch = view.findViewById(R.id.btSearch);

        this.btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_helpFilterFragment_to_offersFragment);
            }
        });

    }

}
