package org.ubt.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ubt.product.model.OrderTaking;

@Repository
public interface OrderTakingRepository extends JpaRepository<OrderTaking, Integer> {

}
