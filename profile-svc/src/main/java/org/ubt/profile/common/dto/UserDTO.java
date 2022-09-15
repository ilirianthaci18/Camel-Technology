package org.ubt.profile.common.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.ubt.profile.common.enums.AccountState;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    private String name;

    private String surname;

    private String address;

    private String phoneNumber;

    private String email;

    private String password;

    private String role;

    private AccountState accountState;

    private boolean deleted;

    private WishListDTOUser wishList;

    private ShoppingCartDTOUser shoppingCart;

    private List<ShipmentTrackingDTOUser> shipmentTrackings;

    private List<RecommendationDTOUser> recommendations;

    private List<HistoricalOrderDTOUser> historicalOrders;

    @JsonManagedReference
    public WishListDTOUser getWishList() {
        return wishList;
    }

    @JsonManagedReference
    public ShoppingCartDTOUser getShoppingCart() {
        return shoppingCart;
    }

    @JsonManagedReference
    public List<ShipmentTrackingDTOUser> getShipmentTrackings() {
        return shipmentTrackings;
    }

    @JsonManagedReference
    public List<RecommendationDTOUser> getRecommendations() {
        return recommendations;
    }

    @JsonManagedReference
    public List<HistoricalOrderDTOUser> getHistoricalOrders() {
        return historicalOrders;
    }
}
