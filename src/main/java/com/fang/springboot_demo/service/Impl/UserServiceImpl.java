package com.fang.springboot_demo.service.Impl;


import com.fang.springboot_demo.dao.UserDao;
import com.fang.springboot_demo.domain.User;
import com.fang.springboot_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer id) {

        return userDao.getUserById(id);
    }

    @Override
    @Transactional              //添加事务
    public Boolean addUser(User user) {
        return userDao.addUser(user.getName(), user.getAge());
    }

    @Override
    public List<User> getAllUser() {
        Example example = new Example(User.class);
        return userDao.selectAll();
    }
}
