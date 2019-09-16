package edu.mum.qtree.controllers;
import edu.mum.qtree.dto.UserUpdateDto;
import edu.mum.qtree.exceptions.BusinessException;
import edu.mum.qtree.models.custom.UserInfo;
import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.models.entities.UserRole;
import edu.mum.qtree.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "User Resourse",description = "User Resourse")
public class UserController {

    @Autowired
    private UserService userService;

    //APIs

    @ApiOperation(value = "Return all Users Info")
    @GetMapping()
    public List<UserInfo> listUsers()
    {
        return userService.listInfo();
    }

    @ApiOperation(value = "Update User Info by ID")
    @PutMapping()
    public void updateUser(@RequestBody UserUpdateDto dto) throws BusinessException {
        User user = userService.getUser(dto.getId());

        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setUserRole(new UserRole(dto.getRoleId()));
        user.setModifiedOn(new Date());

         userService.save(user);
    }

    @ApiOperation(value = "Return specific Users Info by ID")
    @GetMapping("/{id}")
    public UserInfo getUser(@PathVariable("id") int id) throws BusinessException {
        return userService.getUserInfo(id);
    }

    @ApiOperation(value = "Delete User Info by ID")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) throws BusinessException {
        userService.deleteUser(id);
    }

    @ApiOperation(value = "Activate User by ID")
    @PatchMapping("/{id}")
    public void enableUser(@PathVariable("id") int id) throws BusinessException {
        userService.Enable(id);
    }

}
