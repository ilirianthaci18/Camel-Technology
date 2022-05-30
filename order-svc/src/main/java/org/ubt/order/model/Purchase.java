package org.ubt.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Purchase {
    @Id
    @SequenceGenerator(name = "purchase_sequence", sequenceName = "purchase_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchase_sequence")
    @Column
    private int id;

    @Column
    private double amount;

    @Column
    private String type;
}
