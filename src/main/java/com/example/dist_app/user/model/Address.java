package com.example.dist_app.user.model;

/**
 * Represents a physical address with location details.
 */
public class Address {
    /**
     * The unique identifier for this address.
     */
    private Long id;

    /**
     * The postal/zip code of the address.
     */
    private String zipcode;

    /**
     * The city of the address.
     */
    private String city;

    /**
     * The state or province of the address.
     */
    private String state;

    /**
     * The country of the address.
     */
    private String country;

    /**
     * Creates a new address with the specified attributes.
     *
     * @param id      the unique identifier for this address
     * @param zipcode the postal/zip code
     * @param city    the city
     * @param state   the state or province
     * @param country the country
     */
    public Address(Long id, String zipcode, String city, String state, String country) {
        this.id = id;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    /**
     * Returns the unique identifier of this address.
     *
     * @return the address ID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the unique identifier of this address.
     *
     * @param id the address ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the postal/zip code of the address.
     *
     * @return the zip code
     */
    public String getZipcode() {
        return this.zipcode;
    }

    /**
     * Sets the postal/zip code of the address.
     *
     * @param zipcode the zip code to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Returns the city of the address.
     *
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Sets the city of the address.
     *
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the state or province of the address.
     *
     * @return the state
     */
    public String getState() {
        return this.state;
    }

    /**
     * Sets the state or province of the address.
     *
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns the country of the address.
     *
     * @return the country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Sets the country of the address.
     *
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
