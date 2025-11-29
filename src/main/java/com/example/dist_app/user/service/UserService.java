package com.example.dist_app.user.service;

import com.example.dist_app.user.model.Address;
import com.example.dist_app.user.model.Gender;
import com.example.dist_app.user.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Service implementation for managing user operations.
 * Provides functionality to retrieve, create, and manage users and their addresses.
 */
@Service
public class UserService implements IUserService {

    /**
     * Counter for generating unique user IDs.
     */
    private final AtomicLong userIdCounter = new AtomicLong(6);

    /**
     * Counter for generating unique address IDs.
     */
    private final AtomicLong addressIdCounter = new AtomicLong(6);

    /**
     * In-memory list of users.
     */
    private final List<User> users = new ArrayList<>(
        List.of(
            new User(1L, "Sheev", "Palpatine", "sheev.palpatine@example.org", new Address(1L, "00001", "Imperial Palace", "Coruscant", "Galactic Empire"), Gender.MALE),
            new User(2L, "Obi-Wan", "Kenobi", "obi-wan.kenobi@example.org", new Address(2L, "88420", "Stewjon", "Outer Rim", "Galactic Republic"), Gender.MALE),
            new User(3L, "Luke", "Skywalker", "luke.skywalker@example.org", new Address(3L, "30777", "Tatooine", "Anchorhead", "Outer Rim Territories"), Gender.MALE),
            new User(4L, "Lea", "Skywalker", "lea.skywalker@example.org", new Address(4L, "11001", "Aldera", "Alderaan", "Core Worlds"), Gender.FEMALE),
            new User(5L, "Han", "Solo", "han.solo@example.org", new Address(5L, "50123", "Corellia City", "Coronet", "Independent Systems"), Gender.MALE)
        )
    );

    /**
     * Retrieves all users.
     *
     * @return a list of all users
     */
    public List<User> getUsers() {
        return this.users;
    }

    /**
     * Adds an existing user to the system.
     *
     * @param user the user to add
     */
    public void add(User user) {
        this.users.add(user);
    }

    /**
     * Creates a new user with the specified attributes and adds them to the system.
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
    public User create(
        String firstname,
        String lastname,
        String email,
        String zipcode,
        String city,
        String state,
        String country,
        Gender gender
    ) {
        Address address = new Address(
            this.addressIdCounter.incrementAndGet(),
            zipcode,
            city,
            state,
            country
        );

        User user = new User(
            this.userIdCounter.incrementAndGet(),
            firstname,
            lastname,
            email,
            address,
            gender
        );

        this.users.add(user);

        return user;
    }

    /**
     * Retrieves a predefined list of sample addresses.
     *
     * @return a list of sample addresses
     */
    public List<Address> getAddresses() {
        return List.of(
            new Address(1L, "00001", "Imperial Palace", "Coruscant", "Galactic Empire"),
            new Address(2L, "88420", "Stewjon", "Outer Rim", "Galactic Republic"),
            new Address(3L, "30777", "Tatooine", "Anchorhead", "Outer Rim Territories"),
            new Address(4L, "11001", "Aldera", "Alderaan", "Core Worlds"),
            new Address(5L, "50123", "Corellia City", "Coronet", "Independent Systems")
        );
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user
     * @return the user, or null if not found
     */
    public User getUserById(Long id) {
        for (User user : this.getUsers()) {
            if (user.getId().equals(id)) {
                return user;
            }
        }

        return null;
    }
}