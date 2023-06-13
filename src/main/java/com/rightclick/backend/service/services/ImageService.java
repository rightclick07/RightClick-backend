package com.rightclick.backend.service.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    public void uploadImage(Integer productId, MultipartFile file) throws Exception;
}
