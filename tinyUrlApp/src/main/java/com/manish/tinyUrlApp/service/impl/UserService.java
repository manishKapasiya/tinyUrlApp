package com.manish.tinyUrlApp.service.impl;

import com.manish.tinyUrlApp.data.entity.User;
import com.manish.tinyUrlApp.data.repository.UserRepo;
import com.manish.tinyUrlApp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    UserRepo userRepo;

    public UserService(@Autowired UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public Optional<User> getUser(Long userId) {
        if(userId==null) return Optional.empty();
        return userRepo.findById(userId);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

}
