package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(CreateUserReq req) {
        // TODO: Validate info

        // Check email exist
        User user = userRepository.findByEmail(req.getEmail());
        if (user != null) {
            throw new BadRequestException("Email đã tồn tại trong hệ thống. Vui lòng sử dụng email khác.");
        }

        user = User.builder()
                    .fullName(req.getFullName())
                    .email(req.getEmail())
                    .phone(req.getPhone())
                    .password(req.getPassword())
                    .build();
        return userRepository.save(user);
    }
}
