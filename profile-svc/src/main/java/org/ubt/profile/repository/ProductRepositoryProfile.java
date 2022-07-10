package org.ubt.profile.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.ubt.profile.model.ProductProfile;

import java.util.List;

@Repository
public interface ProductRepositoryProfile extends CrudRepository<ProductProfile, Long> {

    @Query("Select productProfile from ProductProfile productProfile where productProfile.productCode=:productCode")
    ProductProfile findProductsByProductCode(@Param("productCode") String productCode);
}
