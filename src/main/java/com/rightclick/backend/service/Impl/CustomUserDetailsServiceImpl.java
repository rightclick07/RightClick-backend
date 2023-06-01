package com.rightclick.backend.service.Impl;

import com.rightclick.backend.Entity.UserEntity;
import com.rightclick.backend.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user= usersRepository.findByUsername(username);
        if(username.equals(user.getUsername())){
            return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("user not found");
        }
    }


}
