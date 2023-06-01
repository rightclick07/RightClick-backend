package com.rightclick.backend.service.Impl;

import com.rightclick.backend.Entity.UserEntity;
import com.rightclick.backend.Repository.UsersRepository;
import com.rightclick.backend.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public String getFullUserNameService(String username) {
        UserEntity user=this.usersRepository.findByUsername(username);
        String fullname=user.getFullName();
        return fullname;
    }
}
