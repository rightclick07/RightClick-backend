package com.rightclick.backend.controller;


import com.rightclick.backend.Entity.BlogEntity;
import com.rightclick.backend.Entity.UserEntity;
import com.rightclick.backend.model.ResponseDTO;
import com.rightclick.backend.service.services.BlogService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    private static final Logger log= LogManager.getLogger(BlogController.class);

    @GetMapping("/getAllBlogs")
    public ResponseDTO<List<BlogEntity>> getAllBlogs(){
        log.info("Starting Controller for method {getAllBlogs}{}");

        return blogService.getAllBlogData();
    }
    @GetMapping("/getBlogById/{id}")
    public ResponseDTO<Optional<BlogEntity>> getBlogById(@PathVariable("id") Integer id){
        log.info("Starting Controller for method {getBlogById} for id {}");

        return blogService.getBlogById(id);
    }
}
