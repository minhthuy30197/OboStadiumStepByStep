package com.example.demo.entity;

import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class ProductSizeId implements Serializable {
    private String productId;

    private int size;
}
