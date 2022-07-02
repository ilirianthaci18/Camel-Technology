package org.ubt.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ubt.product.model.WareHouse;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse, Integer> {

}