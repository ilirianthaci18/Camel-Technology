package org.ubt.profile.common.mappers;

import org.modelmapper.ModelMapper;
import org.ubt.profile.common.dto.ShoppingCartDTO;
import org.ubt.profile.common.dto.ShoppingCartDTOUser;;
import org.ubt.profile.model.ShoppingCart;

import static org.ubt.profile.common.mappers.UserMapper.toUserDTOShoppingCart;

public class ShoppingCartMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static ShoppingCartDTO toShoppingCartDTO(ShoppingCart shoppingCart) {
        ShoppingCartDTO shoppingCartDTO = modelMapper.map(shoppingCart, ShoppingCartDTO.class);

        shoppingCartDTO.setId(shoppingCart.getId());
        shoppingCartDTO.setCreated(shoppingCart.getCreated());
        shoppingCartDTO.setDateAdded(shoppingCart.getDateAdded());
        shoppingCartDTO.setQuantity(shoppingCart.getQuantity());
        shoppingCartDTO.setUser(toUserDTOShoppingCart(shoppingCart.getUser()));

        return shoppingCartDTO;
    }

    public static ShoppingCartDTOUser toShoppingCartDTOUser(ShoppingCart shoppingCart) {
        ShoppingCartDTOUser shoppingCartDTOUser = modelMapper.map(shoppingCart, ShoppingCartDTOUser.class);

        shoppingCartDTOUser.setCreated(shoppingCart.getCreated());
        shoppingCartDTOUser.setDateAdded(shoppingCart.getDateAdded());
        shoppingCartDTOUser.setQuantity(shoppingCart.getQuantity());

        return shoppingCartDTOUser;
    }

}
