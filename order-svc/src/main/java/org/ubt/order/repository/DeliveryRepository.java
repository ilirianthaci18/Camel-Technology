package org.ubt.order.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.ubt.order.model.Delivery;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery,Long> {

    @Query("SELECT delivery FROM Delivery delivery WHERE delivery.name=:name")
    Delivery findDeliveryByEmail(@Param("name") String name);
}
