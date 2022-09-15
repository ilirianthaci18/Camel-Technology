package org.ubt.profile.common.mappers;


import org.modelmapper.ModelMapper;
import org.ubt.profile.common.dto.*;
import org.ubt.profile.model.User;

import static org.ubt.profile.common.mappers.HistoricalOrderMapper.toHistoricalOrderDTOUser;
import static org.ubt.profile.common.mappers.RecommendationMapper.toRecommendationDTOUser;
import static org.ubt.profile.common.mappers.ShipmentTrackingMapper.toShipmentTrackingDTOUser;
import static org.ubt.profile.common.mappers.ShoppingCartMapper.toShoppingCartDTOUser;
import static org.ubt.profile.common.mappers.WishListMapper.toWishListDTOUser;

public class UserMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAccountState(user.getAccountState());
        userDTO.setAddress(user.getAddress());
        userDTO.setDeleted(user.isDeleted());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setRole(user.getRole());
        userDTO.setSurname(user.getSurname());
        userDTO.setWishList(toWishListDTOUser(user.getWishList()));
        userDTO.setShoppingCart(toShoppingCartDTOUser(user.getShoppingCart()));

//        user.getRecommendationList().stream().forEach(recommendation -> {
//            userDTO.getRecommendations().add(toRecommendationDTOUser(recommendation));
//        });

        user.getHistoricalOrderList().stream().forEach(historicalOrder -> {
            userDTO.getHistoricalOrders().add(toHistoricalOrderDTOUser(historicalOrder));
        });

        user.getShipmentTrackingList().stream().forEach(shipmentTracking -> {
            userDTO.getShipmentTrackings().add(toShipmentTrackingDTOUser(shipmentTracking));
        });

        return userDTO;
    }

    public static UserDTOShoppingCart toUserDTOShoppingCart(User user) {
        UserDTOShoppingCart userDTOShoppingCart = modelMapper.map(user, UserDTOShoppingCart.class);

        userDTOShoppingCart.setName(user.getName());
        userDTOShoppingCart.setAccountState(user.getAccountState());
        userDTOShoppingCart.setAddress(user.getAddress());
        userDTOShoppingCart.setDeleted(user.isDeleted());
        userDTOShoppingCart.setEmail(user.getEmail());
        userDTOShoppingCart.setPhoneNumber(user.getPhoneNumber());
        userDTOShoppingCart.setRole(user.getRole());
        userDTOShoppingCart.setSurname(user.getSurname());

        return userDTOShoppingCart;
    }

    public static UserDTOWishList toUserDTOWishList(User user) {
        UserDTOWishList userDTOWishList = modelMapper.map(user, UserDTOWishList.class);

        userDTOWishList.setName(user.getName());
        userDTOWishList.setAccountState(user.getAccountState());
        userDTOWishList.setAddress(user.getAddress());
        userDTOWishList.setDeleted(user.isDeleted());
        userDTOWishList.setEmail(user.getEmail());
        userDTOWishList.setPhoneNumber(user.getPhoneNumber());
        userDTOWishList.setRole(user.getRole());
        userDTOWishList.setSurname(user.getSurname());

        return userDTOWishList;
    }

    public static UserDTORecommendation toUserDTORecommendation(User user) {
        UserDTORecommendation userDTORecommendation = modelMapper.map(user, UserDTORecommendation.class);

        userDTORecommendation.setName(user.getName());
        userDTORecommendation.setAccountState(user.getAccountState());
        userDTORecommendation.setAddress(user.getAddress());
        userDTORecommendation.setDeleted(user.isDeleted());
        userDTORecommendation.setEmail(user.getEmail());
        userDTORecommendation.setPhoneNumber(user.getPhoneNumber());
        userDTORecommendation.setRole(user.getRole());
        userDTORecommendation.setSurname(user.getSurname());

        return userDTORecommendation;
    }

    public static UserDTOHistoricalOrder toUserDTOHistoricalOrder(User user) {
        UserDTOHistoricalOrder userDTOHistoricalOrder = modelMapper.map(user, UserDTOHistoricalOrder.class);

        userDTOHistoricalOrder.setName(user.getName());
        userDTOHistoricalOrder.setAccountState(user.getAccountState());
        userDTOHistoricalOrder.setAddress(user.getAddress());
        userDTOHistoricalOrder.setDeleted(user.isDeleted());
        userDTOHistoricalOrder.setEmail(user.getEmail());
        userDTOHistoricalOrder.setPhoneNumber(user.getPhoneNumber());
        userDTOHistoricalOrder.setRole(user.getRole());
        userDTOHistoricalOrder.setSurname(user.getSurname());

        return userDTOHistoricalOrder;
    }

    public static UserDTOShipmentTracking toUserDTOShipmentTracking(User user) {
        UserDTOShipmentTracking userDTOShipmentTracking = modelMapper.map(user, UserDTOShipmentTracking.class);

        userDTOShipmentTracking.setName(user.getName());
        userDTOShipmentTracking.setAccountState(user.getAccountState());
        userDTOShipmentTracking.setAddress(user.getAddress());
        userDTOShipmentTracking.setDeleted(user.isDeleted());
        userDTOShipmentTracking.setEmail(user.getEmail());
        userDTOShipmentTracking.setPhoneNumber(user.getPhoneNumber());
        userDTOShipmentTracking.setRole(user.getRole());
        userDTOShipmentTracking.setSurname(user.getSurname());

        return userDTOShipmentTracking;
    }

}
