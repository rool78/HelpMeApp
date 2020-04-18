package com.rms.helpmeapp.dataAccess;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rms.helpmeapp.model.Offer;
import com.rms.helpmeapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class FirebaseRealtimeDB {

    private static final String PATH_USERS = "users";
    private static final String CHILD_ID = "id";
    private static final String CHILD_OFFER = "offer";
    private static final String CHILD_LOCATION ="location";

    private List<User> usersFilter;
    private DatabaseReference mReference;

    /**
     *  Añadimos usuario en el caso en que no tenga debido al primer login, se crea en
     *  el primer login
     */
    public void addUser(User user){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(PATH_USERS);
        DatabaseReference keyRef = reference.push();
        String key = keyRef.getKey();
        User userWithId = user;
        userWithId.setId(key);
        keyRef.setValue(userWithId);
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
    public void addOffer(String userId, Offer offer){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(PATH_USERS);
        reference.child(userId).child(CHILD_OFFER).setValue(offer);
    }


    /**
     * Eliminamos oferta
     */
    public void removeOffer(String userId){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(PATH_USERS);
        reference.child(userId).child(CHILD_OFFER).removeValue();
    }

    /**
     * De esta forma aqui no nos sirve, esto iria bien para implementarlo directamente en la
     * recycle view, dando la opcion de cargar en tiempo real las tarjetas
     */
    public List<User> filterUsersByLocation(String location){
        usersFilter = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(PATH_USERS);
        reference.orderByChild(CHILD_LOCATION).equalTo(location).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                usersFilter.add(dataSnapshot.getValue(User.class));
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