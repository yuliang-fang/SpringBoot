package com.fang.springboot_demo.service.Impl;


import com.fang.springboot_demo.dao.UserDao;
import com.fang.springboot_demo.domain.User;
import com.fang.springboot_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer id) {

        return userDao.getUserById(id);
    }

    @Override
    public Boolean addUser(User user) {
        return userDao.addUser(user.getName(),user.getAge());
    }
}
