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
public class Brand {
    @Id
    @SequenceGenerator(name = "brand_sequence", sequenceName = "brand_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_sequence")
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String logo;

    @Column
    private String category;

    @Column
    private boolean favorite;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "brand", fetch = FetchType.LAZY)
    private List<Product> productList = new ArrayList<>();

    @JsonManagedReference
    public List<Product> getProductList() {
        return productList;
    }
}
