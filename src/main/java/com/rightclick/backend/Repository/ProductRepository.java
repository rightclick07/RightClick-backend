package com.rightclick.backend.Repository;

import com.rightclick.backend.Entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductsEntity,Integer> {

    @Override
    List<ProductsEntity> findAll();

    @Override
    Optional<ProductsEntity> findById(Integer integer);
}
