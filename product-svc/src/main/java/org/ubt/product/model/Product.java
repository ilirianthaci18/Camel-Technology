package org.ubt.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    private String fullDescription;

    @Column
    private String shortDescription;

    @Column
    private String battery;

    @Column
    private String mainImage;

    @Column
    private Date createdTime;

    @Column
    private boolean enabled;

    @Column
    private boolean inStock;

    @Column
    private double price;

    @Column
    private double discountPercentage;

    @Column
    private String category;

    @Column
    private String color;

    @Column
    private double length;

    @Column
    private double weight;

    @Column
    private double height;

    @Column
    private double width;

    @Column
    private boolean favorite;

    @Column
    private double avgRating;

    @Column
    private int availability;

    /*@Column
    private Map<String, String> technicalDetails;

    @Column
    private Set<String> whatsInTheBox;

    @Column
    private List<String> reviews;*/

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private Inventory inventory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    private WareHouse wareHouse;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_taking_id", referencedColumnName = "id")
    private OrderTaking orderTaking;
}
