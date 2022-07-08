package org.ubt.order.model;


import lombok.*;
import org.ubt.order.common.enums.DeliveryStatus;
import org.ubt.order.common.enums.DeliveryType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Delivery {

    @Id
    @SequenceGenerator(name = "delivery_sequence", sequenceName = "delivery_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_sequence")
    @Column
    private Long id;

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column
    private DeliveryType type;

    @NonNull
    @Column
    private LocalDateTime date;

    @NonNull
    @Column
    private DeliveryStatus status;

    @NonNull
    @Column
    private String address;

    @NonNull
    @Column
    private boolean paid;

    @NonNull
    @Column
    private double needsToPay;
}
