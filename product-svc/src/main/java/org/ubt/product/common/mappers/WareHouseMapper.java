package org.ubt.product.common.mappers;

import org.modelmapper.ModelMapper;
import org.ubt.product.common.dto.WareHouseDTO;
import org.ubt.product.common.dto.WareHouseDTOProduct;
import org.ubt.product.model.WareHouse;

import static org.ubt.product.common.mappers.ProductMapper.toProductDTOWareHouse;

public class WareHouseMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static WareHouseDTO toWareHouseDTO(WareHouse wareHouse) {
        WareHouseDTO wareHouseDTO = modelMapper.map(wareHouse, WareHouseDTO.class);

        wareHouseDTO.setId(wareHouse.getId());
        wareHouseDTO.setWareHouseLocation(wareHouse.getWareHouseLocation());
        wareHouseDTO.setWareHouseSerialNumberPalett(wareHouse.getWareHouseSerialNumberPalett());
        wareHouseDTO.setRFID(wareHouse.isRFID());

        wareHouse.getProductList().stream().forEach(product -> {
            wareHouseDTO.getProducts().add(toProductDTOWareHouse(product));
        });

        return wareHouseDTO;
    }

    public static WareHouseDTOProduct toInventoryDTOWareHouse(WareHouse wareHouse) {
        WareHouseDTOProduct wareHouseDTOProduct = modelMapper.map(wareHouse, WareHouseDTOProduct.class);

        wareHouseDTOProduct.setWareHouseLocation(wareHouse.getWareHouseLocation());
        wareHouseDTOProduct.setWareHouseSerialNumberPalett(wareHouse.getWareHouseSerialNumberPalett());
        wareHouseDTOProduct.setRFID(wareHouse.isRFID());

        return wareHouseDTOProduct;
    }
}
