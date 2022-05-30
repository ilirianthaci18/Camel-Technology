package org.ubt.order.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Logistics {

    @Id
    @SequenceGenerator(name = "logistics_sequence", sequenceName = "logistics_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logistics_sequence")
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private int drivers;

    @Column
    private LocalDateTime paid;

    @Column
    private LocalDateTime dateAccepted;

    //@Column
    //private Delivery deliveryDetails;

    @Column
    private double fee;

    @Column
    private String deliveredBy;

    @Column
    private String acceptedBy;


}
