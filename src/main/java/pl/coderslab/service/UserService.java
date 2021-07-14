package pl.coderslab.service;

import pl.coderslab.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    void add(User user);
}
