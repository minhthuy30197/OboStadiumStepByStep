package com.example.demo.service;

import com.example.demo.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {
    Page<Post> getListPost(int page);

    Post getPostById(long id);

    List<Post> getLatestPostsNotId(long id);
}
