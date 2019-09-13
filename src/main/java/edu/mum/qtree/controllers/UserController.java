package edu.mum.qtree.controllers;
import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //APIs

    @GetMapping()
    public List<User> listUsers()
    {
        return userService.list();
    }

    @PostMapping()
    public User addUser(@RequestBody User user)
    {
        return userService.save(user);
    }

    @PutMapping()
    public User updateUser(@RequestBody User user)
    {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id)
    {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id)
    {
        userService.deleteUser(id);
    }

    @PatchMapping("/{id}")
    public void enableUser(@PathVariable("id") int id)
    {
        userService.Enable(id);
    }

}
