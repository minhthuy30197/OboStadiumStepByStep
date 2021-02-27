package com.example.demo.controller.anonymous;

import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.model.request.LoginReq;
import com.example.demo.security.CustomUserDetails;
import com.example.demo.security.JwtTokenUtil;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import static com.example.demo.config.Constant.MAX_AGE_COOKIE;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/api/register")
    public ResponseEntity<?> register(@RequestBody CreateUserReq req, HttpServletResponse response) {
        // Create user
        User result = userService.createUser(req);

        // Gen token
        UserDetails principal = new CustomUserDetails(result);
        String token = jwtTokenUtil.generateToken(principal);

        // Add token to cookie to login
        Cookie cookie = new Cookie("JWT_TOKEN",token);
        cookie.setMaxAge(MAX_AGE_COOKIE);
        cookie.setPath("/");
        response.addCookie(cookie);

        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(result, UserDto.class);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginReq req, HttpServletResponse response) {
        // Authenticate
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getEmail(),
                            req.getPassword()
                    )
            );

            // Gen token
            String token = jwtTokenUtil.generateToken((CustomUserDetails) authentication.getPrincipal());

            // Add token to cookie to login
            Cookie cookie = new Cookie("JWT_TOKEN", token);
            cookie.setMaxAge(MAX_AGE_COOKIE);
            cookie.setPath("/");
            response.addCookie(cookie);

            ModelMapper modelMapper = new ModelMapper();
            UserDto userDto = modelMapper.map(((CustomUserDetails) authentication.getPrincipal()).getUser(), UserDto.class);
            return ResponseEntity.ok(userDto);
        } catch (Exception ex) {
            throw new BadRequestException("Email hoặc mật khẩu không chính xác");
        }
    }
}
