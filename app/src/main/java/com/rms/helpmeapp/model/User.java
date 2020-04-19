package com.rms.helpmeapp.model;

import java.util.HashSet;
import java.util.Set;

public class User {

    private String id;
    private String authId;
    private String name;
    private String photoUrl;

    private Set<Offer> offer = new HashSet<>();

    public User(String authId, String name, String photoUrl) {
        this.authId = authId;
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public User(String authId, String name, String photoUrl, Set<Offer> offer) {
        this.authId = authId;
        this.name = name;
        this.photoUrl = photoUrl;
        this.offer = offer;
    }

    public User(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId){
        this.authId = authId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Set<Offer> getOffer() {
        return offer;
    }

    public void setOffer(Set<Offer> offer) {
        this.offer = offer;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", authId='" + authId + '\'' +
                ", name='" + name + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", offer=" + offer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
