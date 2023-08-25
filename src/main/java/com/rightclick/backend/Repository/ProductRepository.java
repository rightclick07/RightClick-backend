package com.rightclick.backend.Repository;

import com.rightclick.backend.Entity.ProductsEntity;
import com.rightclick.backend.model.ResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductsEntity,Integer> {

    @Override
    List<ProductsEntity> findAll();

    @Override
    Optional<ProductsEntity> findById(Integer integer);

    List<ProductsEntity> findByProductTypeAndCategory(String productType, String category);

    List<ProductsEntity> findByProductType(String productType);
}
