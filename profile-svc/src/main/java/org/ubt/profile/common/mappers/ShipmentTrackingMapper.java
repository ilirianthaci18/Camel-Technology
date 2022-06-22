package org.ubt.profile.common.mappers;

import org.modelmapper.ModelMapper;
import org.ubt.profile.common.dto.ShipmentTrackingDTO;
import org.ubt.profile.common.dto.ShipmentTrackingDTOUser;
import org.ubt.profile.model.ShipmentTracking;

import static org.ubt.profile.common.mappers.UserMapper.toUserDTOShipmentTracking;

public class ShipmentTrackingMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static ShipmentTrackingDTO toShipmentTrackingDTO(ShipmentTracking shipmentTracking) {
        ShipmentTrackingDTO shipmentTrackingDTO = modelMapper.map(shipmentTracking, ShipmentTrackingDTO.class);

        shipmentTrackingDTO.setId(shipmentTracking.getId());
        shipmentTrackingDTO.setShipmentBy(shipmentTracking.getShipmentBy());
        shipmentTrackingDTO.setShipmentDate(shipmentTracking.getShipmentDate());
        shipmentTrackingDTO.setShipmentDescription(shipmentTracking.getShipmentDescription());
        shipmentTrackingDTO.setShipmentFeedback(shipmentTracking.getShipmentFeedback());
        shipmentTrackingDTO.setShipmentRegionId(shipmentTracking.getShipmentRegionId());
        shipmentTrackingDTO.setShipmentStatus(shipmentTracking.getShipmentStatus());
        shipmentTrackingDTO.setShipmentType(shipmentTracking.getShipmentType());
        shipmentTrackingDTO.setUser(toUserDTOShipmentTracking(shipmentTracking.getUser()));

        return shipmentTrackingDTO;
    }

    public static ShipmentTrackingDTOUser toShipmentTrackingDTOUser(ShipmentTracking shipmentTracking) {
        ShipmentTrackingDTOUser shipmentTrackingDTOUser = modelMapper.map(shipmentTracking, ShipmentTrackingDTOUser.class);

        shipmentTrackingDTOUser.setShipmentBy(shipmentTracking.getShipmentBy());
        shipmentTrackingDTOUser.setShipmentDate(shipmentTracking.getShipmentDate());
        shipmentTrackingDTOUser.setShipmentDescription(shipmentTracking.getShipmentDescription());
        shipmentTrackingDTOUser.setShipmentFeedback(shipmentTracking.getShipmentFeedback());
        shipmentTrackingDTOUser.setShipmentRegionId(shipmentTracking.getShipmentRegionId());
        shipmentTrackingDTOUser.setShipmentStatus(shipmentTracking.getShipmentStatus());
        shipmentTrackingDTOUser.setShipmentType(shipmentTracking.getShipmentType());

        return shipmentTrackingDTOUser;
    }
}
