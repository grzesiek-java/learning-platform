package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;
import java.util.List;
import java.util.Optional;

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
    public User get(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void add(User user){
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}
