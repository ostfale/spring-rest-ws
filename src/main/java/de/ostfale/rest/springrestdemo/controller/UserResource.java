package de.ostfale.rest.springrestdemo.controller;

import de.ostfale.rest.springrestdemo.bean.User;
import de.ostfale.rest.springrestdemo.exception.UserNotFoundException;
import de.ostfale.rest.springrestdemo.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by Uwe Sauerbrei on 16.03.2018
 */
@RestController
public class UserResource {


    @Autowired
    private UserDaoService userDaoService;

    // retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        User user = userDaoService.findById(id);
        if (user != null) {
            return user;
        }
        throw new UserNotFoundException("id-" + id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
