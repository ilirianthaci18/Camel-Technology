package org.ubt.profile.model;

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
    @SequenceGenerator(name="user_sequence",sequenceName = "user_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
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

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="user",fetch = FetchType.LAZY)
    private List<Recommendation> recommendationList=new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="user",fetch = FetchType.LAZY)
    private List<ShipmentTracking> shipmentTrackingList=new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy="user",fetch = FetchType.LAZY)
    private List<HistoricalOrder> historicalOrderList=new ArrayList<>();
}
