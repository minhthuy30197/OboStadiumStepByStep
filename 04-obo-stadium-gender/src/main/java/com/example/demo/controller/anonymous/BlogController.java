package com.example.demo.controller.anonymous;

import com.example.demo.entity.Post;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
