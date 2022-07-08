package org.ubt.product.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class OrderTaking {
    @Id
    @SequenceGenerator(name = "order_taking_sequence", sequenceName = "order_taking_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_taking_sequence")
    @Column
    private int id;

    @Column
    private String status;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "orderTaking", fetch = FetchType.LAZY)
    private List<Product> productList = new ArrayList<>();

    @JsonManagedReference
    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        if (!productList.contains(product)) {
            productList.add(product);
            product.setOrderTaking(this);
        }
    }
}
