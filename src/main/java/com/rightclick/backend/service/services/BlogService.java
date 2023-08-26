package com.rightclick.backend.service.services;

import com.rightclick.backend.Entity.BlogEntity;
import com.rightclick.backend.model.ResponseDTO;

import java.util.List;
import java.util.Optional;

public interface BlogService {

    ResponseDTO<List<BlogEntity>> getAllBlogData();
    ResponseDTO<Optional<BlogEntity>> getBlogById(Integer id);
}
