package org.ubt.profile.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.ubt.profile.model.WishList;

public interface WishListRepository extends CrudRepository<WishList,Long> {

    @Query("SELECT wishlist from WishList wishlist where wishlist.userId=:userId")
    WishList getWishListByUserId(@Param("userId") String userId);
}
