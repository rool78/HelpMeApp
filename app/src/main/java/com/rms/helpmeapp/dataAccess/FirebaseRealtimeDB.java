package com.rms.helpmeapp.dataAccess;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.rms.helpmeapp.model.Offer;
import com.rms.helpmeapp.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseRealtimeDB {

    private static final String PATH_USERS = "users";
    private static final String PATH_OFFERS = "offers";
    private static final String CHILD_ID = "id";
    private static final String CHILD_LOCATION ="location";

    private List<Offer> offers = new ArrayList<>();

    /**
     *  Añadimos usuario en el caso en que no tenga debido al primer login, se crea en
     *  el primer login
     */
    public void addUser(User user){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(PATH_USERS);
        reference.setValue(user.getId());
        reference.child(user.getId()).setValue(user);
    }


    public Task<DataSnapshot> findUserById(String id) {
        final TaskCompletionSource<DataSnapshot> source = new TaskCompletionSource<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(PATH_USERS);
        reference.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
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

    /**
     * Editamos perfil entero dado un ID, podemos pasarle un usuario directamente
     */
    public void editProfile(User editedUser){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(PATH_USERS);
        reference.child(editedUser.getId()).child(CHILD_ID).setValue(editedUser);
    }

    /**
     * Añadmios oferta
     */
    public void addOffer(String id, Offer offer) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(PATH_OFFERS);
        Map map = new HashMap();
        String key = reference.push().getKey();
        map.put("time", ServerValue.TIMESTAMP);
        map.put("id", key);
        reference.child(key).setValue(offer);
        reference.child(key).updateChildren(map);
    }

    /**
     * Eliminamos oferta
     */
    public void removeOffer(String userId){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(PATH_USERS);
        reference.child(userId).child(PATH_OFFERS).removeValue();
    }

    public Task<DataSnapshot> findAllOffers() {
        final TaskCompletionSource<DataSnapshot> source = new TaskCompletionSource<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(PATH_OFFERS);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
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

    /**
     * De esta forma aqui no nos sirve, esto iria bien para implementarlo directamente en la
     * recycle view, dando la opcion de cargar en tiempo real las tarjetas
     */
    public List<User> filterUsersByLocation(String location){
        //usersFilter = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(PATH_USERS);
        reference.orderByChild(CHILD_LOCATION).equalTo(location).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //usersFilter.add(dataSnapshot.getValue(User.class));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return null;
    }
}
