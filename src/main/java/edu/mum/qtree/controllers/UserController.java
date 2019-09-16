package edu.mum.qtree.controllers;
import edu.mum.qtree.dto.UserUpdateDto;
import edu.mum.qtree.exceptions.BusinessException;
import edu.mum.qtree.models.custom.UserInfo;
import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.models.entities.UserRole;
import edu.mum.qtree.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

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
        logger.trace(String.format("updateUser accessed data:[%s]", dto));
        logger.debug(String.format("updateUser accessed data:[%s]", dto));
        User user = userService.getUser(dto.getId());

        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setUserRole(new UserRole(dto.getRoleId()));
        user.setModifiedOn(new Date());

         userService.save(user);
        logger.debug(String.format("user should be updated successfully"));
    }

    @GetMapping("/{id}")
    public UserInfo getUser(@PathVariable("id") int id) throws BusinessException {
        logger.trace(String.format("getUser accessed user id:[%s]", id));
        logger.debug(String.format("getUser accessed user id:[%s]", id));
        return userService.getUserInfo(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) throws BusinessException {
        logger.trace(String.format("deleteUser accessed user id:[%s]", id));
        userService.deleteUser(id);
    }

    @PatchMapping("/{id}")
    public void enableUser(@PathVariable("id") int id) throws BusinessException {
        logger.trace(String.format("enableUser accessed user id:[%s]", id));
        userService.Enable(id);
    }

}
