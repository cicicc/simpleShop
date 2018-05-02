package com.afeng.dao;

import com.afeng.domain.User;

import java.sql.SQLException;

public interface UserDao {
    void register(User user) throws SQLException;

    User verifyUsername(String username) throws SQLException;
}
