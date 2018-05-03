package com.afeng.service.impl;

import com.afeng.dao.UserDao;
import com.afeng.dao.impl.UserDaoImpl;
import com.afeng.domain.User;
import com.afeng.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public int register(User user)  {
        //调用dao层方法 如果注册成功就返回1 注册失败就返回0
        int registerRes = 0;
        try {
            registerRes =userDao.register(user);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registerRes;
    }

    @Override
    public User verifyUsername(String username) {
        //调用dao层方法 判断数据库中是否已经有了与注册者填写用户名相同的用户名
        //如果有就返回user对象 没有就返回null
        User existUser = null;
        try {
            existUser = userDao.verifyUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existUser;
    }

    @Override
    public Integer active(String activeCode) {
        //调用dao层将用户的状态改为已经激活状态 这个时候还应该考虑如果用户更改了地址栏中的地址的话
        // 那么我们应该返回错误的信息 告诉用户code有误
        try {
            return userDao.active(activeCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
