package org.AshInc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping(value="/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping(value="/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping(value="/users")
    User createOrSaveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping(value="/users/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userService.findById(id).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            user.setEmail(newUser.getEmail());
            return userService.save(user);
        }).orElseGet(() -> userService.save(newUser));
    }

    @DeleteMapping(value="/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
} 