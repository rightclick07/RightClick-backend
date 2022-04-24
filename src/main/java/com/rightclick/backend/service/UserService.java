package com.rightclick.backend.service;

import com.rightclick.backend.Entity.UserEntity;
import com.rightclick.backend.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public String getFullUserNameService(String username){
        UserEntity user=this.usersRepository.findByUserName(username);
        String firstname=user.getFirstName();
        String middlename=user.getMiddleName();
        String lastname=user.getLastName();
        String fullname=firstname+" "+middlename+" "+lastname;
        return fullname;
    }
}
