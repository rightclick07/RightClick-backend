package com.rightclick.backend.service;

import com.rightclick.backend.Entity.UserEntity;
import com.rightclick.backend.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user= usersRepository.findByUserName(username);
        if(username.equals(user.getUserName())){
            return new User(user.getUserName(),user.getPassword(),new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("user not found");
        }
    }
}
