package com.hwd.service.impl;

import com.hwd.dao.UserDao;
import com.hwd.domain.User;
import com.hwd.service.UserService;
import com.hwd.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {

        User user=new User();
        user=userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
