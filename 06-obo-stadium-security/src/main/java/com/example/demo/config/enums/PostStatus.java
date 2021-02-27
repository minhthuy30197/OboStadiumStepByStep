package com.example.demo.config.enums;

import lombok.Getter;

@Getter
public enum PostStatus {
    PUBLIC_POST(1), DRAFT_POST(0);
    private int status;

    PostStatus(int status) {
        this.status = status;
    }
}
