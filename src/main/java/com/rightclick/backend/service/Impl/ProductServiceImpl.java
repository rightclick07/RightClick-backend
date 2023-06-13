package com.rightclick.backend.service.Impl;

import com.rightclick.backend.Entity.ProductsEntity;
import com.rightclick.backend.Repository.ProductRepository;
import com.rightclick.backend.constants.AppConstants;
import com.rightclick.backend.controller.ProductController;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.service.services.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    AppConstants appConstants;

    private static final Logger log= LogManager.getLogger(ProductServiceImpl.class);

    @Override
    public ResponseDTO<List<ProductsEntity>> getAllProductListData() {
        log.info("Starting Service for method {getAllProductListData}");

        ResponseDTO<List<ProductsEntity>> listResponseDTO  =new ResponseDTO<>();
        try{
            List<ProductsEntity> productsEntityList=this.productRepository.findAll();
            listResponseDTO.setHttpStatusCode(HttpStatus.OK);
            listResponseDTO.setMessage(appConstants.successMsg);
            listResponseDTO.setPayload(productsEntityList);

        } catch (UsernameNotFoundException e){
            e.printStackTrace();
            listResponseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            listResponseDTO.setMessage(appConstants.bad_credential);
            listResponseDTO.setPayload(null);
        }
        return listResponseDTO;
    }

    @Override
    public ResponseDTO<Optional<ProductsEntity>> getProductById(Integer id) {
        log.info("Starting Service for method {getProductById} for id :{}",id);

        ResponseDTO<Optional<ProductsEntity>> responseDTO  =new ResponseDTO<>();
        try{
            Optional<ProductsEntity> productsEntity=this.productRepository.findById(id);
            responseDTO.setHttpStatusCode(HttpStatus.OK);
            responseDTO.setMessage(appConstants.successMsg);
            responseDTO.setPayload(productsEntity);

        } catch (UsernameNotFoundException e){
            e.printStackTrace();
            responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage(appConstants.bad_credential);
            responseDTO.setPayload(null);
        }
        return responseDTO;
    }
}
