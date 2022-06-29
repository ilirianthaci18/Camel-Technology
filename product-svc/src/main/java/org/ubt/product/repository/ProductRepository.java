package org.ubt.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.ubt.product.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("Select product FROM Product product WHERE product.code= :productCode")
    Product findProductByCode(@Param("productCode") String productCode);

    @Query("Select product.name From Product product")
    List<String> productName();

    //TODO update
    @Query(value = "Update product SET quantity = (quantity + 1) where code = :productCode",nativeQuery = true)
    void decreaseQuantityProductByCode(@Param("productCode") String productCode);
}
