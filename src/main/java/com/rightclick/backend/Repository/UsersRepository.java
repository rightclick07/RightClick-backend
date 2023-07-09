package com.rightclick.backend.Repository;

import com.rightclick.backend.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, BigInteger> {


 boolean existsByUsername(String name);

 UserEntity findByUsername(String username);

}
