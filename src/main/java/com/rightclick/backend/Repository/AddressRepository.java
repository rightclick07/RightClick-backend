package com.rightclick.backend.Repository;

import com.rightclick.backend.Entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Integer> {

   List<AddressEntity> findAllByUserId(Integer id);
}
