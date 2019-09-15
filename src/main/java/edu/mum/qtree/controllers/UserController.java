package edu.mum.qtree.controllers;
import edu.mum.qtree.dto.UserUpdateDto;
import edu.mum.qtree.exceptions.BusinessException;
import edu.mum.qtree.models.custom.UserInfo;
import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.models.entities.UserRole;
import edu.mum.qtree.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //APIs

    @GetMapping()
    public List<UserInfo> listUsers()
    {
        return userService.listInfo();
    }

    @PutMapping()
    public void updateUser(@RequestBody UserUpdateDto dto) throws BusinessException {
        User user = userService.getUser(dto.getId());

        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setUserRole(new UserRole(dto.getRoleId()));
        user.setModifiedOn(new Date());

         userService.save(user);
    }

    @GetMapping("/{id}")
    public UserInfo getUser(@PathVariable("id") int id) throws BusinessException {
        return userService.getUserInfo(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) throws BusinessException {
        userService.deleteUser(id);
    }

    @PatchMapping("/{id}")
    public void enableUser(@PathVariable("id") int id) throws BusinessException {
        userService.Enable(id);
    }

}
