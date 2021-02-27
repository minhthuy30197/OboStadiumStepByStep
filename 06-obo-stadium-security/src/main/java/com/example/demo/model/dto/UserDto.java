package com.example.demo.model.dto;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private long id;

    private String fullName;

    private String email;

    private List<String> roles;

    private String address;

    private String phone;

    private boolean status;
}
