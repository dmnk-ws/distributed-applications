package com.example.dist_app.user.service;

import com.example.dist_app.user.model.Address;
import com.example.dist_app.user.model.Gender;
import com.example.dist_app.user.model.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    void add(User user);
    User create(String firstname, String lastname, String email, String zipcode, String city, String state, String country, Gender gender);
    List<Address> getAddresses();
    User getUserById(Long id);
}