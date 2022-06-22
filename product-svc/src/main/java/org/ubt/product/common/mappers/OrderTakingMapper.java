package org.ubt.product.common.mappers;

import org.modelmapper.ModelMapper;
import org.ubt.product.common.dto.OrderTakingDTO;
import org.ubt.product.common.dto.OrderTakingDTOProduct;
import org.ubt.product.model.OrderTaking;

import static org.ubt.product.common.mappers.ProductMapper.toProductDTOOrderTaking;

public class OrderTakingMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static OrderTakingDTO toOrderTakingDTO(OrderTaking orderTaking) {
        OrderTakingDTO orderTakingDTO = modelMapper.map(orderTaking, OrderTakingDTO.class);

        orderTakingDTO.setId(orderTaking.getId());
        orderTakingDTO.setStatus(orderTaking.getStatus());

        orderTaking.getProductList().stream().forEach(product -> {
            orderTakingDTO.getProducts().add(toProductDTOOrderTaking(product));
        });

        return orderTakingDTO;
    }

    public static OrderTakingDTOProduct toOrderTakingDTOProduct(OrderTaking orderTaking) {
        OrderTakingDTOProduct orderTakingDTOProduct = modelMapper.map(orderTaking, OrderTakingDTOProduct.class);

        orderTakingDTOProduct.setStatus(orderTaking.getStatus());

        return orderTakingDTOProduct;
    }
}
