package edu.mum.qtree.services;

import edu.mum.qtree.dao.UserRepository;
import edu.mum.qtree.exceptions.BusinessException;
import edu.mum.qtree.models.custom.UserInfo;
import edu.mum.qtree.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

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
        return userRepository.findAll().stream().map(this::MapUserToUserInfo).collect(Collectors.toList());
    }

    public UserInfo signUp(User user)
    {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return MapUserToUserInfo(userRepository.saveAndFlush(user));
    }
    public UserInfo save(User user)
    {
        return MapUserToUserInfo(userRepository.saveAndFlush(user));
    }

    public User getUser(int id) throws BusinessException {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new BusinessException("User not found"));
    }

    public UserInfo getUserInfo(int id) throws BusinessException {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new BusinessException("User not found"));

        return MapUserToUserInfo(user);

    }

    public Optional<User> getUserByUserName(String email)
    {
        return userRepository.findByEmail(email);

    }

    public void deleteUser(int id) throws BusinessException {
        User userToUpdate = getUser(id);

        //ToDo:Check if this super admin, as super admin shouldn't be deleted
        userToUpdate.setIsEnabled(false);
        save(userToUpdate);
    }

    public void Enable(int id) throws BusinessException {
        User userToUpdate = getUser(id);
        userToUpdate.setIsEnabled(true);
        save(userToUpdate);
    }


    public UserInfo MapUserToUserInfo(User user)
    {
        UserInfo userInfo = new UserInfo(user.getId(),
                user.getEmail(),
                user.getName(),
                user.getUserRole().getName(),
                user.getIsEnabled());
        return userInfo;
    }

}
