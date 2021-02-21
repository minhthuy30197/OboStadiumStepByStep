package com.example.demo.controller.anonymous;

import com.example.demo.entity.Post;
import com.example.demo.exception.NotFoundException;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/tin-tuc")
    public String getBlogPage(Model model,  @RequestParam(required = false, defaultValue = "1") int page) {
        Page<Post> posts = blogService.getListPost(page);

        model.addAttribute("totalPages", posts.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("listPost", posts.getContent());

        return "blog/blog";
    }

    @GetMapping("/tin-tuc/{slug}/{id}")
    public String getPostDetailPage(Model model, @PathVariable long id) {
        try {
            Post post = blogService.getPostById(id);
            model.addAttribute("post", post);
        } catch (NotFoundException ex) {
            return "error/404";
        }

        List<Post> latestPosts = blogService.getLatestPostsNotId(id);
        model.addAttribute("latestPosts", latestPosts);

        return "blog/detail";
    }
}
