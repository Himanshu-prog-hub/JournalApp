package com.himanshu.journelApp.service;

import com.himanshu.journelApp.entity.User;
import com.himanshu.journelApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User user)
    {
        userRepository.save(user);
    }

    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    public void createUser(User user)
    {
        userRepository.save(user);
    }

    public User findUserByUserName(String userName)
    {
        return userRepository.findByUserName(userName);
    }
}
