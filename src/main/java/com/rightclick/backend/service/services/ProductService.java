package com.rightclick.backend.service.services;

import com.rightclick.backend.Entity.ProductsEntity;
import com.rightclick.backend.model.ResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ResponseDTO<List<ProductsEntity>> getAllProductListData();
    ResponseDTO<List<ProductsEntity>> getAllProductByCategoryAndSubcategory(String category,String subcategory);
    ResponseDTO<Optional<ProductsEntity>> getProductById(Integer id);
}
