package edu.mum.qtree.services;

import edu.mum.qtree.dao.UserRepository;
import edu.mum.qtree.exceptions.BusinessException;
import edu.mum.qtree.models.custom.UserInfo;
import edu.mum.qtree.models.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> list()
    {
        return userRepository.findAll();
    }

    public List<UserInfo> listInfo()
    {
        logger.debug("listInfo accessed");
        return userRepository.findAll().stream().map(this::MapUserToUserInfo).collect(Collectors.toList());
    }

    public UserInfo signUp(User user)
    {
        logger.debug("signUp accessed");
        logger.trace(String.format("signUp accessed, user date:[%s]", user));
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        logger.debug("signUp finished");
        return MapUserToUserInfo(userRepository.saveAndFlush(user));

    }
    public UserInfo save(User user)
    {
        logger.debug("save accessed");
        logger.trace(String.format("save accessed, user date:[%s]", user));
        logger.debug("save finished");
        return MapUserToUserInfo(userRepository.saveAndFlush(user));
    }

    public User getUser(int id) throws BusinessException {
        logger.debug("getUser accessed");
        logger.trace(String.format("getUser accessed, user id:[%s]", id));
        return userRepository
                .findById(id)
                .orElseThrow(() -> new BusinessException("User not found"));

    }

    public UserInfo getUserInfo(int id) throws BusinessException {
        logger.debug("getUser accessed");
        logger.trace(String.format("getUser accessed, user id:[%s]", id));
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new BusinessException("User not found"));

        return MapUserToUserInfo(user);

    }

    public Optional<User> getUserByUserName(String email)
    {
        logger.debug("getUserByUserName accessed");
        logger.trace(String.format("getUserByUserName accessed, user email:[%s]", email));

        return userRepository.findByEmail(email);

    }

    public void deleteUser(int id) throws BusinessException {
        logger.debug("deleteUser accessed");
        logger.trace(String.format("deleteUser accessed, user id:[%s]", id));

        User userToUpdate = getUser(id);

        //ToDo:Check if this super admin, as super admin shouldn't be deleted
        userToUpdate.setIsEnabled(false);
        save(userToUpdate);
    }

    public void Enable(int id) throws BusinessException {
        logger.debug("Enable accessed");
        logger.trace(String.format("Enable accessed, user id:[%s]", id));

        User userToUpdate = getUser(id);
        userToUpdate.setIsEnabled(true);
        save(userToUpdate);
    }


    public UserInfo MapUserToUserInfo(User user)
    {
        logger.debug("MapUserToUserInfo accessed");
        logger.trace(String.format("Enable accessed, user data:[%s]", user));

        UserInfo userInfo = new UserInfo(user.getId(),
                user.getEmail(),
                user.getName(),
                user.getUserRole().getName(),
                user.getIsEnabled());
        return userInfo;
    }

}
