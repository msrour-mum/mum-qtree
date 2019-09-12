package edu.mum.qtree.services;

import edu.mum.qtree.dao.UserRepository;
import edu.mum.qtree.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> list()
    {
        return (List<User>) userRepository.findAll();
    }

    public void Add(User user)
    {
        userRepository.save(user);
    }

    public Optional<User> getUser(int id)
    {
        return userRepository.findById(id);

    }

}
