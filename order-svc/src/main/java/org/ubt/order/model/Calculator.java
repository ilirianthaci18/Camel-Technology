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
public class Calculator {
    @Id
    @SequenceGenerator(name = "calculator_sequence", sequenceName = "calculator_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calculator_sequence")
    @Column
    private int id;

    @Column
    private String name;

}
