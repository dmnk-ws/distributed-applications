package com.example.dist_app.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/users")
public class UserController {

    private final AtomicLong counter = new AtomicLong(6);
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
        User user = new User(
            counter.incrementAndGet(),
            firstname,
            lastname,
            email,
            new Address(
                6L,
                zipcode,
                city,
                state,
                country
            ),
            gender
        );

        this.userService.add(user);

        return ResponseEntity.ok(user);
    }
}
