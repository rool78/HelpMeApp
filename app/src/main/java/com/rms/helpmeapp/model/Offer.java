package com.rms.helpmeapp.model;

public class Offer {

    private String title;
    private String description;
    private String country;
    private String city;
    private String province;
    private String adress;

    private int offerType;

    public Offer(){

    }

    public Offer(String title, String description, String country, String city, String province, String address, int offerType) {
        this.title = title;
        this.description = description;
        this.country = country;
        this.city = city;
        this.province = province;
        this.adress = address;
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

    @Override
    public String toString() {
        return "Offer{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", adress='" + adress + '\'' +
                ", offerType=" + offerType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offer offer = (Offer) o;

        if (offerType != offer.offerType) return false;
        if (title != null ? !title.equals(offer.title) : offer.title != null) return false;
        return description != null ? description.equals(offer.description) : offer.description == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + offerType;
        return result;
    }
}
