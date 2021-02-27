package com.example.demo.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "product")
@Table(name = "product")
@TypeDef(
        name = "json",
        typeClass = JsonStringType.class
)
public class Product {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", nullable = false, length = 300)
    private String name;

    @Column(name = "slug", nullable = false)
    private String slug;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "price")
    private long price;

    @Column(name = "total_sold")
    private int totalSold;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "is_available", columnDefinition = "TINYINT(1)")
    private boolean isAvailable;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @Type(type = "json")
    @Column(name = "product_images", columnDefinition = "json")
    private ArrayList<String> productImages;

    @Type(type = "json")
    @Column(name = "onfeet_images", columnDefinition = "json")
    private ArrayList<String> onfeetImages;

    @PreRemove
    private void removeCategories() {
        this.categories.clear();
    }
}

