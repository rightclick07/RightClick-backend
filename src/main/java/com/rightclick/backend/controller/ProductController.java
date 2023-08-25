package com.rightclick.backend.controller;

import com.rightclick.backend.Entity.ProductsEntity;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.service.services.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    private static final Logger log= LogManager.getLogger(ProductController.class);


    @GetMapping("/getAllProductList")
    public ResponseDTO<List<ProductsEntity>> getProductList(){
        log.info("Starting Controller for method {getProductList}");
        return productService.getAllProductListData();
    }

    @GetMapping("/getProductById/{id}")
    public ResponseDTO<Optional<ProductsEntity>> getProductById(@PathVariable Integer id){
        log.info("Starting Controller for method {getProductList} for Id :" ,id);
        return productService.getProductById(id);
    }

    @GetMapping("/getProductsByCategoryAndSubCategory")
    public ResponseDTO<List<ProductsEntity>> getProductsByCategoryAndSubcategory(
            @RequestParam(required = false) String productType,
            @RequestParam(required = false) String category) {
        log.info("Starting Controller for method {getProductsByCategoryAndSubcategory} for Category & subcategory :" ,category,productType);
        return productService.getAllProductByCategoryAndSubcategory(productType,category);
    }
}
