package com.example.dist_app.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
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

}
