package com.manish.tinyUrlApp.service;

import com.manish.tinyUrlApp.data.entity.User;

import java.util.Optional;

public interface IUserService {

    Optional<User> getUser(Long userId);
    User saveUser(User user);

}
