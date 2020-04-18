package com.rms.helpmeapp.model;

public class User {

    private String id;
    private String authId;
    private String name;
    private String location;
    private String photoUrl;
    private Offer offer;

    public User(String authId, String name, String location, String photoUrl) {
        this.authId = authId;
        this.name = name;
        this.location = location;
        this.photoUrl = photoUrl;
    }

    public User(String authId, String name, String location, String photoUrl, Offer offer) {
        this.authId = authId;
        this.name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @Override
    public String toString() {
        return "User{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", photoUrl='" + photoUrl + '\'' +
                    ", offer=" + offer +
                    '}';
    }
}
