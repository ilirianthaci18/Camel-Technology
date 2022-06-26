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
public class Coupon {
    @Id
    @SequenceGenerator(name = "coupon_sequence", sequenceName = "coupon_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupon_sequence")
    @Column
    private Long id;

    @Column
    private String code;

    @Column
    private double discount_percentage;

    @Column
    private boolean is_enabled;
}
