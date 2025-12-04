package com.example.dist_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for the application root endpoint.
 * Provides a simple welcome message.
 */
@RestController
public class WelcomeController {

    /**
     * Default constructor for WelcomeController.
     */
    public WelcomeController() {
    }

    /**
     * Returns a welcome message for the root endpoint.
     *
     * @return a greeting string
     */
    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

}