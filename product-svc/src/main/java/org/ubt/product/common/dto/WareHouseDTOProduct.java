package org.ubt.product.common.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseDTOProduct {
    private boolean RFID;

    private String wareHouseLocation;

    private String wareHouseSerialNumberPalett;
}
