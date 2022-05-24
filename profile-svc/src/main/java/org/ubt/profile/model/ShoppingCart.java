package org.ubt.profile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ShoppingCart {
    @Id
    @SequenceGenerator(name="shopping_cart_sequence",sequenceName = "shopping_cart_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "shopping_cart_sequence")
    @Column
    private int id;

    @Column
    private Date created;

    @Column
    private int quantity;

    @Column
    private Date dateAdded;

    /*@Column
    private List<Integer> productIds;*/

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "user_shopping_cart_id"))
    private User user;
}
