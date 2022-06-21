package org.ubt.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class WareHouse {
    @Id
    @SequenceGenerator(name = "warehouse_sequence", sequenceName = "warehouse_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "warehouse_sequence")
    @Column
    private int id;

    @Column
    private boolean RFID;

    @Column
    private String wareHouseLocation;

    @Column
    private String wareHouseSerialNumberPalett;

//    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "warehouse", fetch = FetchType.LAZY)
//    private List<Product> productList = new ArrayList<>();
}
