package com.rightclick.backend.service.Impl;

import com.rightclick.backend.Entity.Image;
import com.rightclick.backend.Repository.ImageRepository;
import com.rightclick.backend.service.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestBody.*;
import static software.amazon.awssdk.core.sync.RequestBody.fromBytes;

@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public void uploadImage(Integer productId, MultipartFile file) throws Exception {

    }
//        @Value("${aws.s3.bucketName}")
//        private String bucketName;
//
//        @Autowired
//        S3Client s3Client;
//
//        @Autowired
//        ImageRepository imageRepository;
//
//    public void uploadImage(Integer productId, MultipartFile file) throws Exception {
//            // Generate a unique S3 object key for the image
//            String s3ObjectKey = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
//
//
//        try {
//
//            // Upload the image to S3 bucket
//            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
//                    .bucket(bucketName)
//                    .key(s3ObjectKey)
//                    .build();
//            s3Client.putObject(putObjectRequest, fromBytes(file.getBytes()));
//
//            // Get the image URL
//            String imageUrl = "https://" + bucketName + ".s3.amazonaws.com/" + s3ObjectKey;
//
//
//            // Save image metadata to the database
//            Image image = new Image();
//            image.setS3ObjectKey(s3ObjectKey);
//            image.setImageUrl(imageUrl);
//            imageRepository.save(image);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }


}
