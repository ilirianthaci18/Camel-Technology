package org.ubt.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ubt.product.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
