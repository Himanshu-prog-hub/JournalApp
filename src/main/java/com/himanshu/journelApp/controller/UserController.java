package com.himanshu.journelApp.controller;

import com.himanshu.journelApp.entity.User;
import com.himanshu.journelApp.repository.UserRepository;
import com.himanshu.journelApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUser()
    {
        return userService.getAll();
    }

    @PostMapping("/add-user")
    public ResponseEntity<?> createUser(@RequestBody User user)
    {
        try{
            userService.createUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            System.out.println(e);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String username)
    {
        User userDb = userService.findUserByUserName(username);
        if(userDb != null)
        {
            userDb.setUserName(user.getUserName());
            userDb.setPassword(user.getPassword());
            userService.createUser(userDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
