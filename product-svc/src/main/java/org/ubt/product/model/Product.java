package org.ubt.product.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
//@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product", schema = "public")
public class Product {
    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @Column
    private Long id;

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column
    private String code;

    @Column
    private String fullDescription;

    @NonNull
    @Column
    private String shortDescription;

    @NonNull
    @Column
    private String battery;

    @NonNull
    @Column
    private String mainImage;

    @NonNull
    @Column
    private LocalDateTime createdTime;

    @NonNull
    @Column
    private boolean enabled;

    @NonNull
    @Column
    private boolean inStock;

    @NonNull
    @Column
    private double price;

    @NonNull
    @Column
    private double discountPercentage;

    @NonNull
    @Column
    private String category;

    @NonNull
    @Column
    private String color;

    @NonNull
    @Column
    private double length;

    @NonNull
    @Column
    private double weight;

    @NonNull
    @Column
    private double height;

    @NonNull
    @Column
    private double width;

    @NonNull
    @Column
    private boolean favorite;

    @NonNull
    @Column
    private double avgRating;

    @NonNull
    @Column
    private int availability;


//    @Column
//    private Map<String, String> technicalDetails;
//
//    @Column
//    private Set<String> whatsInTheBox;
//
//    @Column
//    private List<String> reviews;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
//    private Inventory inventory;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
//    private WareHouse wareHouse;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "brand_id", referencedColumnName = "id")
//    private Brand brand;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_taking_id", referencedColumnName = "id")
//    private OrderTaking orderTaking;
}
