package com.rms.helpmeapp.ui.profile.model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileDbHelper {

    private static final String PATH_OFFERS = "offers";

    public Task<DataSnapshot> findUserOffers(String id) {
        final TaskCompletionSource<DataSnapshot> source = new TaskCompletionSource<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(PATH_OFFERS);
        reference.orderByChild("userId").equalTo(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                source.setResult(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("@@##--", "Fail?");
            }
        });
        return source.getTask();
    }

}
