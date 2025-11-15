package com.example.dist_app.user.model;

public class Address {
    private Long id;
    private String zipcode;
    private String city;
    private String state;
    private String country;

    public Address(Long id, String zipcode, String city, String state, String country) {
        this.id = id;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
