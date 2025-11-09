package com.example.dist_app.user;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    void add(User user);
    User create(String firstname, String lastname, String email, String zipcode, String city, String state, String country, Gender gender);
    List<Address> getAddresses();
    User getUserById(Long id);
}