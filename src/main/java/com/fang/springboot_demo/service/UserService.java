package com.fang.springboot_demo.service;


import com.fang.springboot_demo.domain.User;

import java.util.List;

public interface UserService {

    User getUserById(Integer id);

    Boolean addUser(User user);

    List<User> getAllUser();

}
