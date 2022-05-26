package org.ubt.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ubt.product.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
