package org.ubt.profile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class WishList {
    @Id
    @SequenceGenerator(name="wishlist_sequence",sequenceName = "wishlist_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "wishlist_sequence")
    @Column
    private int id;

    @Column
    private String details;

    @Column
    private int userId;

    @Column
    private double valueOfWishList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "user_wishlist_id"))
    private User user;
}
