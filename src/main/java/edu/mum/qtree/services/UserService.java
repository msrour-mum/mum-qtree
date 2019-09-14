package edu.mum.qtree.services;

import edu.mum.qtree.dao.UserRepository;
import edu.mum.qtree.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public User signUp(User user)
    {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }
    public User save(User user)
    {
        return userRepository.saveAndFlush(user);
    }

    public Optional<User> getUser(int id)
    {
        return userRepository.findById(id);

    }

    public Optional<User> getUserByUserName(String email)
    {
        return userRepository.findByEmail(email);

    }

    public void deleteUser(int id)
    {
        User userToUpdate = getUser(id).get();

        //ToDo:Check if this super admin, as super admin shouldn't be deleted

        if(userToUpdate != null) {
            userToUpdate.setIsEnabled((byte)0);
            save(userToUpdate);
        }
    }

    public void Enable(int id)
    {
        User userToUpdate = getUser(id).get();

        if(userToUpdate != null) {
            userToUpdate.setIsEnabled((byte)1);
            save(userToUpdate);
        }
    }

}
