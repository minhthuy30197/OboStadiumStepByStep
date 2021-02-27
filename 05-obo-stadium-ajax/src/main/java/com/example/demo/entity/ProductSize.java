package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "product_size")
@Table(name = "product_size")
@IdClass(ProductSizeId.class)
public class ProductSize {
    @Id
    @Column(name="product_id")
    private String productId;

    @Id
    @Column(name = "size")
    private int size;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}

