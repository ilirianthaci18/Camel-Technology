package org.ubt.order.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ubt.order.common.enums.DeliveryStatus;
import org.ubt.order.common.enums.DeliveryType;
import org.ubt.order.model.Delivery;
import org.ubt.order.model.Order;
import org.ubt.order.repository.DeliveryRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

@Service
@Slf4j
@AllArgsConstructor
public class DeliveryServiceImpl implements DeliveryService{

    private DeliveryRepository deliveryRepository;

    @Override
    public void acceptDelivery(Order order) {
        saveToDeliver(new Delivery(order.getCustomerEmail(), DeliveryType.NORMAL, LocalDateTime.now().plusDays(2L),
                DeliveryStatus.PAID,order.getShip_to(),true,0.0));

        addDeliveryToLogistics(deliveryRepository.findDeliveryByEmail(order.getCustomerEmail()));
    }

    @Override
    public void addDeliveryToLogistics(Delivery delivery) {

    }

    @Override
    public void addDeliveryToCourier(Delivery delivery) {

    }

    private void saveToDeliver(Delivery delivery){
        deliveryRepository.save(delivery);
    }
}
