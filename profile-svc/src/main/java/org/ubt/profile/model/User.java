package org.ubt.profile.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ubt.profile.common.enums.AccountState;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String role;

    @Column
    private AccountState accountState;

    @Column
    private boolean deleted;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wishlist_id", referencedColumnName = "id")
    private WishList wishList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id")
    private ShoppingCart shoppingCart;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Recommendation> recommendationList = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "user", fetch = FetchType.LAZY)
    private List<ShipmentTracking> shipmentTrackingList = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "user", fetch = FetchType.LAZY)
    private List<HistoricalOrder> historicalOrderList = new ArrayList<>();

    @JsonManagedReference
    public WishList getWishList() {
        return wishList;
    }

    @JsonManagedReference
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @JsonManagedReference
    public List<Recommendation> getRecommendationList() {
        return recommendationList;
    }

    @JsonManagedReference
    public List<ShipmentTracking> getShipmentTrackingList() {
        return shipmentTrackingList;
    }

    @JsonManagedReference
    public List<HistoricalOrder> getHistoricalOrderList() {
        return historicalOrderList;
    }

    public void addRecommendation(Recommendation recommendation) {
        if (!recommendationList.contains(recommendation)) {
            recommendationList.add(recommendation);
            recommendation.setUser(this);
        }
    }

    public void addShipmentTracking(ShipmentTracking shipmentTracking) {
        if (!shipmentTrackingList.contains(shipmentTracking)) {
            shipmentTrackingList.add(shipmentTracking);
            shipmentTracking.setUser(this);
        }
    }

    public void addHistoricalOrder(HistoricalOrder historicalOrder) {
        if (!historicalOrderList.contains(historicalOrder)) {
            historicalOrderList.add(historicalOrder);
            historicalOrder.setUser(this);
        }
    }

}
