package com.afeng.service.impl;

import com.afeng.dao.UserDao;
import com.afeng.dao.impl.UserDaoImpl;
import com.afeng.domain.User;
import com.afeng.service.UserService;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void register(User user)  {
        try {
            userDao.register(user);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User verifyUsername(String username) {
        User existUser = null;
        try {
            existUser = userDao.verifyUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existUser;
    }
}
