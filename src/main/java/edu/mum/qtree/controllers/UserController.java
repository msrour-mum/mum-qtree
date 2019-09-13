package edu.mum.qtree.controllers;
import edu.mum.qtree.dto.UserAddDto;
import edu.mum.qtree.dto.UserUpdateDto;
import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.models.entities.UserRole;
import edu.mum.qtree.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public User addUser(@RequestBody UserAddDto dto)
    {
        User user = new User();

        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setIsEnabled(dto.getIsEnabled());
        user.setUserRole(new UserRole(dto.getRoleId()));
        user.setCreatedOn(new Date());
        user.setModifiedOn(new Date());

        return userService.save(user);
    }

    @PutMapping()
    public User updateUser(@RequestBody UserUpdateDto dto)
    {
        User user = userService.getUser(dto.getId()).get();

        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setUserRole(new UserRole(dto.getRoleId()));
        user.setModifiedOn(new Date());


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
