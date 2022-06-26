package org.ubt.profile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ShipmentTracking {
    @Id
    @SequenceGenerator(name="shipment_tracking_sequence",sequenceName = "shipment_tracking_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "shipment_tracking_sequence")
    @Column
    private int id;

    @Column
    private String shipmentDate;

    @Column
    private String shipmentType;

    @Column
    private String shipmentDescription;

    @Column
    private String shipmentStatus;

    @Column
    private String shipmentBy;

    @Column
    private String shipmentRegionId;

    @Column
    private String shipmentFeedback;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
