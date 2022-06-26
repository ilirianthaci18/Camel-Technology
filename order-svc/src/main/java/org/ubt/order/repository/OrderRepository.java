package org.ubt.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.ubt.order.model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("SELECT order FROM Order order WHERE order.status =:status")
    List<Order> getCompletedOrders(@Param("status") String status);
}
