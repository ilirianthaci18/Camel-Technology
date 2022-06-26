package org.ubt.product.common.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderTakingDTO {
    private int id;

    private String status;

    private List<ProductDTOOrderTaking> products;

    @JsonManagedReference
    public List<ProductDTOOrderTaking> getProducts() {
        return products;
    }
}
