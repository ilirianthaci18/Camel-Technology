package org.ubt.product.common.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandDTO {
    private int id;

    private String name;

    private String logo;

    private String category;

    private boolean favorite;

    private List<ProductDTOBrand> products;

    @JsonManagedReference
    public List<ProductDTOBrand> getProducts() {
        return products;
    }

}
