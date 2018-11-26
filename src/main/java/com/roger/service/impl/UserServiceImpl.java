package com.roger.service.impl;

import com.roger.pojo.User;
import com.roger.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }
}
