package org.ubt.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.ubt.order.model.Coupon;

import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Long> {

    @Query("SELECT coupon FROM Coupon coupon WHERE coupon.code= :couponCode ")
    Coupon test(@Param("couponCode") String couponCode);
}
