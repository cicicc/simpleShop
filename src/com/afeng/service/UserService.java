package com.afeng.service;

import com.afeng.domain.User;


public interface UserService {
    void register(User user) ;

    User verifyUsername(String username);
}
