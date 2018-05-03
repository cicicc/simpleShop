package com.afeng.service;

import com.afeng.domain.User;


public interface UserService {
    int register(User user) ;

    User verifyUsername(String username);

    Integer active(String activeCode);

    User login(User user);
}
