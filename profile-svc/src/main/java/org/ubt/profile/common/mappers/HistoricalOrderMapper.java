package org.ubt.profile.common.mappers;

import org.modelmapper.ModelMapper;
import org.ubt.profile.common.dto.HistoricalOrderDTO;
import org.ubt.profile.common.dto.HistoricalOrderDTOUser;
import org.ubt.profile.model.HistoricalOrder;

import static org.ubt.profile.common.mappers.UserMapper.toUserDTOHistoricalOrder;

public class HistoricalOrderMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static HistoricalOrderDTO toHistoricalOrderDTO(HistoricalOrder historicalOrder) {
        HistoricalOrderDTO historicalOrderDTO = modelMapper.map(historicalOrder, HistoricalOrderDTO.class);

        historicalOrderDTO.setId(historicalOrder.getId());
        historicalOrderDTO.setOrderType(historicalOrder.getOrderType());
        historicalOrderDTO.setDetails(historicalOrder.getDetails());
        historicalOrderDTO.setUser(toUserDTOHistoricalOrder(historicalOrder.getUser()));

        return historicalOrderDTO;
    }

    public static HistoricalOrderDTOUser toHistoricalOrderDTOUser(HistoricalOrder historicalOrder) {
        HistoricalOrderDTOUser historicalOrderDTOUser = modelMapper.map(historicalOrder, HistoricalOrderDTOUser.class);

        historicalOrderDTOUser.setOrderType(historicalOrder.getOrderType());
        historicalOrderDTOUser.setDetails(historicalOrder.getDetails());

        return historicalOrderDTOUser;
    }
}
