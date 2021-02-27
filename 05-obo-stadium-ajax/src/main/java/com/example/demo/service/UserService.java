package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.model.request.CreateUserReq;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User createUser(CreateUserReq req);
}
