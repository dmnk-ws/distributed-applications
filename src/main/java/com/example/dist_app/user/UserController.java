package com.example.dist_app.user;

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
        return UserService.getUsers();
    }

    @GetMapping("/{id}")
    public User show(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    @PostMapping("/create")
    public User create(
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
            6L,
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

        UserService.addUser(user);

        return user;
    }
}
