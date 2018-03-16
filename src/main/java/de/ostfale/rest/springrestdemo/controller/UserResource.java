package de.ostfale.rest.springrestdemo.controller;

import de.ostfale.rest.springrestdemo.bean.User;
import de.ostfale.rest.springrestdemo.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return userDaoService.findById(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userDaoService.save(user);
    }
}
