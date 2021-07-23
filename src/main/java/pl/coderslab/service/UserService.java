package pl.coderslab.service;

import pl.coderslab.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();

    User get(Long id);

    void add(User user);

    void save(User user);

    User findUserByEmail(String email);

    void delete(Long id);


}
