package org.ubt.profile.common.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentTrackingDTOUser {
    private String shipmentDate;

    private String shipmentType;

    private String shipmentDescription;

    private String shipmentStatus;

    private String shipmentBy;

    private String shipmentRegionId;

    private String shipmentFeedback;
}
