package org.example.service;

import org.example.Repository.UserRepository;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
   UserRepository userRepository;
    public User addUser(User user){
        User savedUser=userRepository.save(user);
        return savedUser;
    }

}
