package com.fang.springboot_demo.controller;

import com.fang.springboot_demo.domain.User;
import com.fang.springboot_demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户controller
 */

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

    private Logger logger =LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);

    }

    @PostMapping("/user")
    public Boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }


    @GetMapping("/users")
    public List<User> getAllUser(){
        logger.debug("this is debug level");
        logger.info("this is info level");
        logger.error("this is error level");
        return userService.getAllUser();
    }
    




}
