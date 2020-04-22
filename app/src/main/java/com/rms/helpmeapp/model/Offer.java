package com.rms.helpmeapp.model;

public class Offer {

    private String id;
    private String userId;
    private String title;
    private String description;
    private String country;
    private String city;
    private String province;
    private String adress;

    private int offerType;

    public Offer(){
    }

    public Offer(String userId, String title, String description, String country, String city, String province, String address, int offerType) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.country = country;
        this.city = city;
        this.province = province;
        this.adress = address;
        this.offerType = offerType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
