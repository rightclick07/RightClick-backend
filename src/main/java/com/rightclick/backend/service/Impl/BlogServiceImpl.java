package com.rightclick.backend.service.Impl;

import com.rightclick.backend.Entity.BlogEntity;
import com.rightclick.backend.Repository.BlogRepository;
import com.rightclick.backend.constants.AppConstants;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.service.services.BlogService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl  implements BlogService {

    @Autowired
    BlogRepository blogRepository;

   AppConstants appConstants;

    private static final Logger log= LogManager.getLogger(BlogServiceImpl.class);

    @Override
    public ResponseDTO<List<BlogEntity>> getAllBlogData() {
        log.info("Starting Service for method {getAllBlogData}");
        ResponseDTO<List<BlogEntity>> listResponseDTO=new ResponseDTO<>();
        try{
            List<BlogEntity> blogEntityList=blogRepository.findAll();
            listResponseDTO.setHttpStatusCode(HttpStatus.OK);
            listResponseDTO.setMessage(appConstants.successMsg);
            listResponseDTO.setPayload(blogEntityList);
        } catch (Exception e){
            e.printStackTrace();
            listResponseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            listResponseDTO.setMessage(appConstants.failureMsg);
            listResponseDTO.setPayload(null);
        }
        return listResponseDTO;
    }

    @Override
    public ResponseDTO<Optional<BlogEntity>> getBlogById(Integer id) {
        log.info("Starting Service for method {getBlogById} for id:",id);
        ResponseDTO<Optional<BlogEntity>> responseDTO= new ResponseDTO<>();

        try{
            Optional<BlogEntity> blogEntity= blogRepository.findById(id);
            responseDTO.setHttpStatusCode(HttpStatus.OK);
            responseDTO.setMessage(appConstants.successMsg);
            responseDTO.setPayload(blogEntity);
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            responseDTO.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage(appConstants.bad_credential);
            responseDTO.setPayload(null);
        }
        return responseDTO;
    }
}
