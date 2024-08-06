package Ada_School.Proyecto_Integrador.service;

import Ada_School.Proyecto_Integrador.model.User;
import Ada_School.Proyecto_Integrador.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    @Service
    public class UserController {

        @Autowired
        private UserRepository userRepository;

        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        public User getUserById(String id) {
            return userRepository.findById(id).orElse(null);
        }

        public User saveUser(User user) {
            return  userRepository.save(user);
        }

        public void deleteUser(String id) {
            userRepository.deleteById(id);
        }
    }
}