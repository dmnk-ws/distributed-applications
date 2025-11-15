package com.example.dist_app.user.controller;

import com.example.dist_app.user.model.Gender;
import com.example.dist_app.user.model.User;
import com.example.dist_app.user.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> index() {
        return this.userService.getUsers();
    }

    @GetMapping("/{id}")
    public User show(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

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
