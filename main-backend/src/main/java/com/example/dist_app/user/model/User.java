package com.example.dist_app.user.model;

/**
 * Represents a user in the system with personal information and address.
 */
public class User {
    /**
     * The unique identifier for this user.
     */
    private Long id;

    /**
     * The first name of the user.
     */
    private String firstname;

    /**
     * The last name of the user.
     */
    private String lastname;

    /**
     * The email address of the user.
     */
    private String email;

    /**
     * The address of the user.
     */
    private Address address;

    /**
     * The gender of the user.
     */
    private Gender gender;

    /**
     * Creates a new user with the specified attributes.
     *
     * @param id        the unique identifier for this user
     * @param firstname the first name of the user
     * @param lastname  the last name of the user
     * @param email     the email address of the user
     * @param address   the address of the user
     * @param gender    the gender of the user
     */
    public User(Long id, String firstname, String lastname, String email, Address address,  Gender gender) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }

    /**
     * Returns the unique identifier of this user.
     *
     * @return the user ID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the unique identifier of this user.
     *
     * @param id the user ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the first name of the user.
     *
     * @return the first name
     */
    public String getFirstname() {
        return this.firstname;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstname the first name to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Returns the last name of the user.
     *
     * @return the last name
     */
    public String getLastname() {
        return this.lastname;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastname the last name to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Returns the email address of the user.
     *
     * @return the email address
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the address of the user.
     *
     * @return the address
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     * Sets the address of the user.
     *
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Returns the gender of the user.
     *
     * @return the gender
     */
    public Gender getGender() {
        return this.gender;
    }

    /**
     * Sets the gender of the user.
     *
     * @param gender the gender to set
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
