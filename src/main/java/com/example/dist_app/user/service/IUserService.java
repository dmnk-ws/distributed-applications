package com.example.dist_app.user.service;

import com.example.dist_app.user.model.Address;
import com.example.dist_app.user.model.Gender;
import com.example.dist_app.user.model.User;

import java.util.List;

/**
 * Service interface for managing user operations.
 */
public interface IUserService {
    /**
     * Retrieves all users.
     *
     * @return a list of all users
     */
    List<User> getUsers();

    /**
     * Adds an existing user to the system.
     *
     * @param user the user to add
     */
    void add(User user);

    /**
     * Creates a new user with the specified attributes.
     *
     * @param firstname the first name of the user
     * @param lastname  the last name of the user
     * @param email     the email address of the user
     * @param zipcode   the postal/zip code of the user's address
     * @param city      the city of the user's address
     * @param state     the state of the user's address
     * @param country   the country of the user's address
     * @param gender    the gender of the user
     * @return the created user
     */
    User create(String firstname, String lastname, String email, String zipcode, String city, String state, String country, Gender gender);

    /**
     * Retrieves all addresses in the system.
     *
     * @return a list of all addresses
     */
    List<Address> getAddresses();

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user
     * @return the user, or null if not found
     */
    User getUserById(Long id);

    /**
     * Retrieves the ID of the current user.
     *
     * @return the current user's ID
     */
    Long getUserId();
}