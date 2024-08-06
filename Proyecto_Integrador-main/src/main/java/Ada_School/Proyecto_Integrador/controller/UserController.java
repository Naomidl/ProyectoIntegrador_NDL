package Ada_School.Proyecto_Integrador.controller;

import Ada_School.Proyecto_Integrador.dto.UserDto;
import Ada_School.Proyecto_Integrador.model.User;
import Ada_School.Proyecto_Integrador.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
        public List<User> getAllUsers() {
            return userService.getAllUsers();
        }

        @GetMapping("/{id}")
        public ResponseEntity<User> getUserById (@PathVariable Long id){
            Optional<User> user = userService.getUserById(id);
            return user.map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
            public User getUserById (@PathVariable("id") String id){
                return userService.getUserById(id);
            }

            @PostMapping
            public User createUser (@RequestBody User user){
                return userService.saveUser(user);
            }

            @PutMapping("/{id}")
            public ResponseEntity<User> updateUser (@PathVariable Long id, @RequestBody User user){
                User updatedUser = userService.updateUser(id, user);
                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
                public User updateUser (@PathVariable("id") String id, @RequestBody User user){
                    user.setId(id);  // Asegurarnos de que setId existe en la clase User
                    return userService.saveUser(user);
                }

                @DeleteMapping("/{id}")
                public ResponseEntity<Void> deleteUser (@PathVariable Long id){
                    public void deleteUser (@PathVariable("id") String id){
                        userService.deleteUser(id);
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    }
                }
            }
        }
    }
}