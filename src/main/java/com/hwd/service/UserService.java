package com.hwd.service;

import com.hwd.dao.UserDao;
import com.hwd.domain.User;

public interface UserService {



    User checkUser(String username, String password);
}
