package org.ubt.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.ubt.product.model.Inventory;
import org.ubt.product.model.Product;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

}
