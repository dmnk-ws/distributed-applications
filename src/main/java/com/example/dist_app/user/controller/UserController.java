package com.example.dist_app.user.controller;

import com.example.dist_app.user.model.Gender;
import com.example.dist_app.user.model.User;
import com.example.dist_app.user.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API controller for user operations.
 * Provides endpoints for retrieving and creating users.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * Service for user operations.
     */
    private final IUserService userService;

    /**
     * Creates a new UserController with the specified user service.
     *
     * @param userService the user service for data operations
     */
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves all users.
     *
     * @return a list of all users
     */
    @GetMapping("/")
    public List<User> index() {
        return this.userService.getUsers();
    }

    /**
     * Retrieves a single user by their ID.
     *
     * @param id the ID of the user to retrieve
     * @return the user with the specified ID
     */
    @GetMapping("/{id}")
    public User show(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    /**
     * Creates a new user with the specified attributes.
     *
     * @param firstname the first name of the user
     * @param lastname  the last name of the user
     * @param email     the email address of the user
     * @param zipcode   the postal/zip code of the user's address (optional)
     * @param city      the city of the user's address (optional)
     * @param state     the state of the user's address (optional)
     * @param country   the country of the user's address (optional)
     * @param gender    the gender of the user
     * @return a ResponseEntity containing the created user
     */
    @PostMapping("/create")
    public ResponseEntity<User> create(
        @RequestParam String firstname,
        @RequestParam String lastname,
        @RequestParam String email,
        @RequestParam(required = false) String zipcode,
        @RequestParam(required = false) String city,
        @RequestParam(required = false) String state,
        @RequestParam(required = false) String country,
        @RequestParam Gender gender
    ) {
        User user = this.userService.create(
            firstname,
            lastname,
            email,
            zipcode,
            city,
            state,
            country,
            gender
        );

        return ResponseEntity.ok(user);
    }
}
