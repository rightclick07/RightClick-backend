package com.rightclick.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AwsS3Config {
//    private String accessKey;
//    private String secretKey;
//
//    public AwsS3Config(@Value("${aws.accessKey}") String accessKey,
//                       @Value("${aws.secretKey}") String secretKey) {
//        this.accessKey = accessKey;
//        this.secretKey = secretKey;
//    }
//    AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);
//
//    @Bean
//    public S3Client s3Client() {
//        return S3Client.builder()
//                .region(Region.AF_SOUTH_1) // Replace with your desired region
//                .credentialsProvider(StaticCredentialsProvider.create(credentials))
//                .build();
//    }
}
