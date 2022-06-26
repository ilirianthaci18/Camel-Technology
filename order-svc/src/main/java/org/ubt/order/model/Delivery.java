package org.ubt.order.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ubt.order.common.enums.DeliveryStatus;
import org.ubt.order.common.enums.DeliveryType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Delivery {

    @Id
    @SequenceGenerator(name = "delivery_sequence", sequenceName = "delivery_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_sequence")
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private DeliveryType type;

    @Column
    private LocalDateTime date;

    @Column
    private DeliveryStatus status;

    @Column
    private String address;

    @Column
    private boolean paid;

    @Column
    private double needsToPay;
}
