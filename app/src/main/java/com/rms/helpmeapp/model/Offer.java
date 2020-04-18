package com.rms.helpmeapp.model;

public class Offer {
    private String title;
    private String description;
    private int offerType;

    public Offer(){

    }

    public Offer(String title, String description, int offerType) {
        this.title = title;
        this.description = description;
        this.offerType = offerType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOfferType() {
        return offerType;
    }

    public void setOfferType(int offerType) {
        this.offerType = offerType;
    }
}
