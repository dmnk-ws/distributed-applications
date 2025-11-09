package com.example.dist_app.user;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    void add(User user);
    List<Address> getAddresses();
    User getUserById(Long id);
}