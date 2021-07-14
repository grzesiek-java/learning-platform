package pl.coderslab.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import java.util.List;

@Service
public class JpaUserService implements UserService{

    private final UserRepository userRepository;

    public JpaUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public void add(User user){
        userRepository.save(user);
    }
}
