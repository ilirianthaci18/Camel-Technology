package org.ubt.product.common.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseDTO {
    private int id;

    private boolean RFID;

    private String wareHouseLocation;

    private String wareHouseSerialNumberPalett;

    private List<ProductDTOWareHouse> products;

    @JsonManagedReference
    public List<ProductDTOWareHouse> getProducts() {
        return products;
    }

}
