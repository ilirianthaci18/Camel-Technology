package org.ubt.product.common.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTOOrderTaking {
    private String name;

    private String code;

    private String fullDescription;

    private String shortDescription;

    private String battery;

    private String mainImage;

    private LocalDateTime createdTime;

    private boolean enabled;

    private boolean inStock;

    private double price;

    private double discountPercentage;

    private String category;

    private String color;

    private double length;

    private double weight;

    private double height;

    private double width;

    private boolean favorite;

    private double avgRating;

    private int availability;
}
