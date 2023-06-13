package com.rightclick.backend.controller;


import com.rightclick.backend.service.services.ImageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {

//    @Autowired
//    ImageService imageService;

//    private static final Logger log= LogManager.getLogger(ImageController.class);
//    @PostMapping(path="/upload",consumes = "multipart/form-data")
//    public ResponseEntity<?> uploadImage(@RequestParam("productId") Integer productId, @RequestParam("file") MultipartFile file) {
//        log.info("Starting Controller for method {uploadImage} Request is :{productId : ",productId+" , file:",file);
//        try {
//            imageService.uploadImage(productId, file);
//            return ResponseEntity.ok("Image uploaded successfully.");
//        } catch (Exception e) {
//            log.error("An error occurred: {}", e.getMessage(), e);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image.");
//        }
//    }


}
