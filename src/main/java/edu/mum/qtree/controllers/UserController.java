package edu.mum.qtree.controllers;

import edu.mum.qtree.models.User;
import edu.mum.qtree.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //APIs

    @GetMapping("/users")
    public List<User> listUsers()
    {
        return userService.list();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user)
    {
        userService.Add(user);
        return user;
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable("id") int id)
    {
        return userService.getUser(id);
    }

}
