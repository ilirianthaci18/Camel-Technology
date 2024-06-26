package org.ubt.product.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Inventory {
    @Id
    @SequenceGenerator(name = "inventory_sequence", sequenceName = "inventory_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_sequence")
    @Column
    private Long id;

    @Column
    private int stockQuantity;

    @Column
    private int triggerQuantity;

    @Column
    private String stockType;

    @Column
    private String inventoryDescription;

    @Column
    private String inventoryType;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "inventory", fetch = FetchType.LAZY)
    private List<Product> productList = new ArrayList<>();

    @JsonManagedReference
    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        if (!productList.contains(product)) {
            productList.add(product);
            product.setInventory(this);
        }
    }
}
