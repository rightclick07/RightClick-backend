package com.rightclick.backend.Repository;

import com.rightclick.backend.Entity.Image;
import com.rightclick.backend.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
