package org.ubt.profile.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProductDTO implements Serializable {
    private String code;
    private String mainImage;
    private String name;
    private double price;

//    private int quantity;
}
