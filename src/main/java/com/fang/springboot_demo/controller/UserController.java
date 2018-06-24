package com.fang.springboot_demo.controller;

import com.fang.springboot_demo.domain.User;
import com.fang.springboot_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户controller
 */

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);

    }

    @PostMapping("/user")
    public Boolean addUser(@RequestBody User user){
        return userService.addUser(user);
    }

}
