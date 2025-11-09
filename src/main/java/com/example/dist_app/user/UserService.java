package com.example.dist_app.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    private final List<User> users = new ArrayList<>(
        List.of(
            new User(1L, "Sheev", "Palpatine", "sheev.palpatine@example.org", new Address(1L, "00001", "Imperial Palace", "Coruscant", "Galactic Empire"), Gender.MALE),
            new User(2L, "Obi-Wan", "Kenobi", "obi-wan.kenobi@example.org", new Address(2L, "88420", "Stewjon", "Outer Rim", "Galactic Republic"), Gender.MALE),
            new User(3L, "Luke", "Skywalker", "luke.skywalker@example.org", new Address(3L, "30777", "Tatooine", "Anchorhead", "Outer Rim Territories"), Gender.MALE),
            new User(4L, "Lea", "Skywalker", "lea.skywalker@example.org", new Address(4L, "11001", "Aldera", "Alderaan", "Core Worlds"), Gender.FEMALE),
            new User(5L, "Han", "Solo", "han.solo@example.org", new Address(5L, "50123", "Corellia City", "Coronet", "Independent Systems"), Gender.MALE)
        )
    );

    public List<User> getUsers() {
        return this.users;
    }

    public void add(User user) {
        this.users.add(user);
    }

    public List<Address> getAddresses() {
        return List.of(
            new Address(1L, "00001", "Imperial Palace", "Coruscant", "Galactic Empire"),
            new Address(2L, "88420", "Stewjon", "Outer Rim", "Galactic Republic"),
            new Address(3L, "30777", "Tatooine", "Anchorhead", "Outer Rim Territories"),
            new Address(4L, "11001", "Aldera", "Alderaan", "Core Worlds"),
            new Address(5L, "50123", "Corellia City", "Coronet", "Independent Systems")
        );
    }

    public User getUserById(Long id) {
        for (User user : this.getUsers()) {
            if (user.getId().equals(id)) {
                return user;
            }
        }

        return null;
    }
}