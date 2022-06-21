package org.ubt.product.common.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;

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

    private InventoryDTOProduct inventory;

    private WareHouseDTOProduct wareHouse;

    private BrandDTOProduct brand;

    private OrderTakingDTOProduct orderTaking;

    @JsonManagedReference
    public InventoryDTOProduct getInventory() {
        return inventory;
    }

    @JsonManagedReference
    public WareHouseDTOProduct getWareHouse() {
        return wareHouse;
    }

    @JsonManagedReference
    public BrandDTOProduct getBrand() {
        return brand;
    }

    @JsonManagedReference
    public OrderTakingDTOProduct getOrderTaking() {
        return orderTaking;
    }

}
