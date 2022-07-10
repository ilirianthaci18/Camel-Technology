package org.ubt.profile.model;

import lombok.*;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class ProductProfile {

    @Id
    @SequenceGenerator(name = "historical_order_sequence", sequenceName = "historical_order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historical_order_sequence")
    @Column
    private Long id;

    @NonNull
    @Column
    private String productImg;

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column
    private double price;

    @NonNull
    @Column
    private String productCode;
}
