package org.ubt.profile.common.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentTrackingDTO {
    private int id;

    private String shipmentDate;

    private String shipmentType;

    private String shipmentDescription;

    private String shipmentStatus;

    private String shipmentBy;

    private String shipmentRegionId;

    private String shipmentFeedback;

    private UserDTOShipmentTracking user;

    @JsonManagedReference
    public UserDTOShipmentTracking getUser() {
        return user;
    }

}
