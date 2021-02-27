package com.example.demo.service.impl;

import com.example.demo.config.enums.PostStatus;
import com.example.demo.entity.Post;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.example.demo.config.Constant.LIMIT_POST_PER_PAGE;

@Component
public class BlogServiceImpl implements BlogService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> getListPost(int page) {
        page--;
        if (page < 0) {
            page = 0;
        }
        Page<Post> posts = postRepository.findAllByStatus(PostStatus.PUBLIC_POST.getStatus(), PageRequest.of(page, LIMIT_POST_PER_PAGE, Sort.by("publishedAt").descending()));
        return posts;
    }

    @Override
    public Post getPostById(long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new NotFoundException("Không tìm thấy tin tức");
        }

        return post.get();
    }

    @Override
    public List<Post> getLatestPostsNotId(long id) {
        return postRepository.getLatestPostsNotId(PostStatus.PUBLIC_POST.getStatus(), id, LIMIT_POST_PER_PAGE);
    }
}
