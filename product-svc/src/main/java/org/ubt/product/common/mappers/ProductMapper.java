package org.ubt.product.common.mappers;

import org.modelmapper.ModelMapper;
import org.ubt.clients.product.dto.CartProductDTO;
import org.ubt.product.model.Product;

public class ProductMapper {
    private static ModelMapper modelMapper=new ModelMapper();

    public static CartProductDTO toCartProductDTO(Product product){
        CartProductDTO cartProductDTO=modelMapper.map(product,CartProductDTO.class);

//        cartProductDTO.setCode(product.getCode());
//        cartProductDTO.setPrice(product.getPrice());
//        cartProductDTO.setMainImage(product.getMainImage());
//        cartProductDTO.setName(product.getName());

        return cartProductDTO;
    }
}
